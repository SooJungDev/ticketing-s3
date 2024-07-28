CREATE TABLE performance
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY comment '공연 고유아이디',
    place_id        BIGINT comment '공연장소 고유아이디',
    name            VARCHAR(255) NOT NULL comment '공연이름',
    start_time      TIMESTAMP    NOT NULL comment '공연 시작날짜',
    end_time        TIMESTAMP    NOT NULL comment '공연 종료날짜',
    poster_url      VARCHAR(2048) comment '공연 포스터 url',
    category        VARCHAR(50)  NOT NULL comment '공연 카테고리',
    status          VARCHAR(50)  NOT NULL comment '공연 상태',
    viewing_age     VARCHAR(50)  NOT NULL comment '관람연령',
    description     TEXT comment '공연 설명',
    cast            TEXT comment '출연진',
    crew            TEXT comment '제작진',
    running_time    BIGINT comment '공연 러닝타임',
    product_company VARCHAR(255) comment '제작사',
    created_at      timestamp    not null comment '생성날짜',
    updated_at      timestamp    not null comment '수정날짜'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4

CREATE TABLE place
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY comment '공연장 고유아이디',
    name          VARCHAR(255) NOT NULL comment '공연장 이름',
    tel_no        VARCHAR(20) comment '공연장 전화번호',
    address       VARCHAR(255) comment '공연장 주소',
    description   TEXT comment '공연장 관련 설명',
    facility_info TEXT comment '공연장 시설정보',
    seat_count    INT comment '공연장 좌석수',
    created_at    timestamp    not null comment '생성날짜',
    updated_at    timestamp    not null comment '수정날짜'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4

CREATE TABLE ticket_price
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY comment '공연별 티켓가격 고유아이디',
    name            VARCHAR(255) NOT NULL comment '공연별 티켓가격 이름',
    price           DECIMAL(10, 2) comment '공연별 티켓가격 판매가격',
    seat_grade      VARCHAR(50) comment '공연별 티켓가격 좌석등급',
    seat_grade_name VARCHAR(50) comment '공연별 티켓가격 좌석등급 이름',
    description     TEXT comment '공연별 티켓가격 설명',
    sale_price      DECIMAL(10, 2) comment '공연별 티켓가격 세일가격',
    performance_id  BIGINT comment '공연별 티켓가격 공연 고유아이디',
    created_at      timestamp    not null comment '생성날짜',
    updated_at      timestamp    not null comment '수정날짜'

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
