// modal.js - TV & 영화 공용 모달 스크립트

const MODAL_API_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwZjliNTBhYTY0NTE2ZmU3MTYxZGU4MGU4M2U4OWE0NSIsIm5iZiI6MTc2ODQ1NzEwNC45MzcsInN1YiI6IjY5Njg4MzkwMTM1OWNmNzAxY2Y0MDhiYyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.Z3WWHuczoqdcg2W96oUfJQTTuYe8ImaMYUomoCXBQJA";
const MODAL_IMG_BASE = "https://image.tmdb.org/t/p/w500";
const MODAL_BASE_URL = "https://api.themoviedb.org/3";

const modalOptions = {
    method: 'GET',
    headers: {
        accept: 'application/json',
        Authorization: `Bearer ${MODAL_API_KEY}`
    }
};

let currentContentId = null;
let currentContentType = null;

// 🎯 모달 열기 함수 - TV와 영화 모두 지원
// 사용법: openModal(12345, 'tv') 또는 openModal(67890, 'movie')
window.openModal = async function (contentId, type = 'tv') {
    currentContentId = contentId;
    currentContentType = type;
    
    const modal = document.getElementById('movie-modal');
    if (!modal) {
        console.error('모달 요소를 찾을 수 없습니다.');
        return;
    }
    
    modal.classList.add('active');
    document.body.style.overflow = 'hidden';

    try {
        // API 엔드포인트 결정
        const endpoint = type === 'movie' ? 'movie' : 'tv';
        
        const [detailRes, creditsRes] = await Promise.all([
            fetch(`${MODAL_BASE_URL}/${endpoint}/${contentId}?language=ko-KR`, modalOptions),
            fetch(`${MODAL_BASE_URL}/${endpoint}/${contentId}/credits?language=ko-KR`, modalOptions)
        ]);

        const detail = await detailRes.json();
        const credits = await creditsRes.json();

        // 배경 이미지
        const modalHeader = document.getElementById('modal-header');
        if (modalHeader) {
            modalHeader.style.backgroundImage = `url(${MODAL_IMG_BASE}${detail.backdrop_path})`;
        }

        // 제목 (TV: name, 영화: title)
        const modalTitle = document.getElementById('modal-title');
        if (modalTitle) {
            modalTitle.textContent = type === 'movie' ? detail.title : detail.name;
        }

        // 평점, 연도, 러닝타임
        let year, runtime;
        
        if (type === 'movie') {
            year = detail.release_date ? detail.release_date.split('-')[0] : '';
            runtime = detail.runtime ? `${detail.runtime}분` : '';
        } else {
            year = detail.first_air_date ? detail.first_air_date.split('-')[0] : '';
            runtime = detail.episode_run_time && detail.episode_run_time[0] 
                ? `${detail.episode_run_time[0]}분` 
                : '';
        }

        const modalInfo = document.getElementById('modal-info');
        if (modalInfo) {
            modalInfo.innerHTML = `
                <span class="rating">⭐ ${detail.vote_average.toFixed(1)}</span>
                <span>${year}</span>
                ${runtime ? `<span>${runtime}</span>` : ''}
            `;
        }

        // 시놉시스
        const modalOverview = document.getElementById('modal-overview');
        if (modalOverview) {
            modalOverview.textContent = detail.overview || '정보가 없습니다.';
        }

        // 출연진 (상위 5명)
        const cast = credits.cast.slice(0, 5).map(c => c.name).join(', ');
        const modalCast = document.getElementById('modal-cast');
        if (modalCast) {
            modalCast.textContent = cast || '정보가 없습니다.';
        }

        // 감독/제작자
        let director;
        if (type === 'movie') {
            const directorObj = credits.crew.find(c => c.job === 'Director');
            director = directorObj ? directorObj.name : '정보가 없습니다.';
        } else {
            const creators = detail.created_by?.map(c => c.name).join(', ');
            director = creators || '정보가 없습니다.';
        }
        
        const modalDirector = document.getElementById('modal-director');
        if (modalDirector) {
            modalDirector.textContent = director;
        }

        // 장르
        const modalGenres = document.getElementById('modal-genres');
        if (modalGenres) {
            modalGenres.innerHTML = detail.genres.map(g => `<span class="genre-tag">${g.name}</span>`).join('');
        }

        // 추가 정보
        const modalExtra = document.getElementById('modal-extra');
        if (modalExtra) {
            if (type === 'movie') {
                modalExtra.innerHTML = `
                    언어: ${detail.original_language.toUpperCase()}<br>
                    인기도: ${detail.popularity.toFixed(0)}<br>
                    투표 수: ${detail.vote_count.toLocaleString()}표
                `;
            } else {
                modalExtra.innerHTML = `
                    언어: ${detail.original_language.toUpperCase()}<br>
                    시즌 수: ${detail.number_of_seasons}개<br>
                    에피소드 수: ${detail.number_of_episodes}개<br>
                    인기도: ${detail.popularity.toFixed(0)}
                `;
            }
        }

    } catch (error) {
        console.error('Error:', error);
        alert('정보를 불러오는데 실패했습니다.');
    }
}

// 모달 닫기 함수
window.closeModal = function () {
    const modal = document.getElementById('movie-modal');
    if (modal) {
        modal.classList.remove('active');
    }
    document.body.style.overflow = 'auto';
}

// 비디오 재생 함수
window.playVideo = function() {
    if (currentContentId && currentContentType) {
        if (currentContentType === 'movie') {
            // 영화는 바로 재생 페이지로 (영화용 플레이어 필요)
            window.location.href = `movie_player.html?id=${currentContentId}`;
        } else {
            // TV는 시즌1 에피소드1로
            window.location.href = `video.html?id=${currentContentId}&season=1&episode=1`;
        }
    } else {
        alert('콘텐츠 정보를 불러올 수 없습니다.');
    }
}

// ESC 키로 모달 닫기
document.addEventListener('keydown', (e) => {
    if (e.key === 'Escape') {
        window.closeModal();
    }
});

// 모달 배경 클릭시 닫기
document.addEventListener('DOMContentLoaded', () => {
    const modal = document.getElementById('movie-modal');
    if (modal) {
        modal.addEventListener('click', (e) => {
            if (e.target.id === 'movie-modal') {
                window.closeModal();
            }
        });
    }
});