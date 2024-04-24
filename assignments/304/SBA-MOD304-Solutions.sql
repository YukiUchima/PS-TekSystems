SELECT name, count(studentid);


-- Q1 DONE
-- Q2 DONE
-- Q3 DONE
-- Q4 DONE
-- Q5 DONE

SELECT course.name, count(*) student_count
FROM course
LEFT JOIN facultycourse fc
ON fc.courseid = course.id
JOIN studentCourse sc
ON sc.courseid = course.id
WHERE facultyid is null
GROUP BY course.name
ORDER BY student_count desc, course.name;
 


-- -------------- Q6 FINISHED
SELECT yr, count(*)
FROM 
	(SELECT distinct studentid, YEAR(startdate) yr
	FROM studentcourse sc2
    ) as sc1
GROUP BY yr
ORDER BY 1, 2 desc;

-- -------------- Q7 FINISHED
SELECT mnth, count(*)
FROM 
	(SELECT distinct studentid, startdate mnth
	FROM studentcourse sc2
    WHERE MONTH(startdate) = 8
    ) as sc1
GROUP BY mnth
ORDER BY 1,2;

SELECT studentid,  DATE_FORMAT(startdate, "%m %y")
FROM studentcourse
WHERE MONTH(startdate) = 8 and studentid in (1,2);

-- -------------- Q8 FINISHED
-- Query list students'
-- SELECT firstname, lastname, numberofCourses in MAJOR dept
-- SORT BY (numberOfCourses DESC, FirstName, LastName)

SELECT student.firstname, student.lastname, count(*)
FROM course c
JOIN studentcourse sc
ON c.id = sc.courseid
JOIN student
ON sc.studentid = student.id
WHERE majorid = deptid
GROUP BY student.firstname, student.lastname
ORDER BY 3 desc, 1, 2; 

-- -------------- Q9 FINISHED
-- avg should be rounded to first decimal place
-- SELECT student.firstname, student.lastname, avg(progress) < 50%
-- ORDER BY avg desc, firstname, lastname

SELECT s.firstname, s.lastname, ROUND(AVG(progress),1) avg_score
FROM studentcourse sc
JOIN student s
ON sc.studentid = s.id
WHERE studentid IN (
	SELECT studentid
	FROM studentcourse
	GROUP BY studentid
	HAVING AVG(progress) < 50
)
GROUP BY studentid
ORDER BY 3 desc, 1,2;


-- -------------- Q10 FINISHED
-- query overall progress of each course rounded to ONE decimal place
-- order by avg progress DESC, courseName

SELECT c.name, ROUND(avg(progress),1) avg_progr
FROM studentcourse sc
JOIN course c
ON c.id = sc.courseid
GROUP BY 1
ORDER BY 2 desc, 1;

-- -------------- Q11 FINISHED

SELECT course.name, ROUND(avg(progress),1)
FROM studentcourse sc
JOIN COURSE ON course.id = sc.courseid
GROUP BY courseid
ORDER BY 2 desc
LIMIT 1;

-- -------------- Q12 FINISHED

SELECT firstname, lastname, ROUND(avg(progress),1) avg_progress
FROM facultycourse fc
JOIN studentcourse sc
USING (courseid)
JOIN faculty ON (faculty.id = facultyid)
GROUP BY facultyid
ORDER BY 3 desc, 1, 2;

-- -------------- Q13 FINISHED
SELECT firstname, lastname, 
	CASE
		WHEN MIN(progress) < 40 THEN 'F'
		WHEN MIN(progress) < 50 THEN 'D'
		WHEN MIN(progress) < 60 THEN 'C'
		WHEN MIN(progress) < 70 THEN 'B'
        ELSE 'A'
	END AS 'Minimum Grade',
    CASE
		WHEN MAX(progress) < 40 THEN 'F'
		WHEN MAX(progress) < 50 THEN 'D'
		WHEN MAX(progress) < 60 THEN 'C'
		WHEN MAX(progress) < 70 THEN 'B'
        ELSE 'A'
	END AS 'Maximum Grade'
FROM studentcourse sc
JOIN student ON id = studentid
GROUP BY studentid
ORDER BY 3 desc, 4 desc, 1,2;












 