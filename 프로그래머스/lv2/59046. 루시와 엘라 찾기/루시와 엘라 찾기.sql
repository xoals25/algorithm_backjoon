-- 코드를 입력하세요
SELECT 
    a.ANIMAL_ID,
    a.NAME,
    a.SEX_UPON_INTAKE
FROM ANIMAL_INS as a
WHERE a.NAME IN('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty')
ORDER BY a.ANIMAL_ID;