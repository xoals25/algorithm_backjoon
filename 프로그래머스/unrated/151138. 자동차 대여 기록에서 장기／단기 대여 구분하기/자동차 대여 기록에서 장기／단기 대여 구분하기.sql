-- 코드를 입력하세요
SELECT 
    c.HISTORY_ID,
    c.CAR_ID,
    DATE_FORMAT(c.START_DATE, '%Y-%m-%d') as START_DATE,
    DATE_FORMAT(c.END_DATE, '%Y-%m-%d') as END_DATE,
    IF(DATEDIFF(END_DATE, START_DATE) >= 29, '장기 대여', '단기 대여') as RENT_TYPE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY as c
WHERE c.START_DATE LIKE '2022-09%'
ORDER BY c.HISTORY_ID DESC;