-- 코드를 입력하세요
SELECT I.REST_ID, I.REST_NAME, I.FOOD_TYPE, I.FAVORITES, I.ADDRESS, ROUND(AVG(R.REVIEW_SCORE), 2) as SCORE
FROM REST_INFO as I JOIN REST_REVIEW as R
ON I.REST_ID = R.REST_ID
WHERE I.ADDRESS like '서울%'
GROUP BY I.REST_ID
ORDER BY SCORE desc, I.FAVORITES desc;