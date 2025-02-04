WITH ENROLL_DATE AS (
    SELECT 
            ANIMAL_ID, 
            RANK() OVER (ORDER BY DATETIME ASC) ENROLL
    FROM ANIMAL_INS
)
SELECT A.DATETIME
FROM 
    ANIMAL_INS AS A 
    JOIN ENROLL_DATE AS E
    ON A.ANIMAL_ID = E.ANIMAL_ID
WHERE E.ENROLL = 1;

