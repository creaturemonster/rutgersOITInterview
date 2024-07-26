# rutgersOITInterview
#Question 1
Write a PL/SQL procedure to calculate and update the final grades for students based on their scores in assignments, midterms, and finals. The procedure should accept the following parameters: 
1. p_student_id (Number)
2. p_assignment_weight (Number)
3. p_midterm_weight (Number)
4. p_final_weight (Number) 

The procedure should: 
1. calculate the final grade for the student using the formula: final_grade = (assignment_score * p(assignment_weight) + (midterm_score * p_midterm_weight) + (final_score * p_final_weight)
2. update the final_grade column in the students table with the calculated grade
3. Use proper exception handling to manage any potential errors


CREATE TABLE students (
student_id NUMBER PRIMARY KEY, 
assignment_score NUMBER, 
midterm_score NUMBER, 
final_score NUMBER, 
final_grade NUMBER
);



INSERT INTO students VALUES (1, 85, 78, 90, NULL);
INSERT INTO students VALUES (2, 92, 88, 84, NULL);
INSERT INTO students VALUES (3, 70, 60, 65, NULL);

COMMIT;


CREATE OR REPLACE PROCEDURE calculate_final_grade(
p_student_id in number,
p_assignment_weight in number,
p_midterm_weight in number,
p_final_weight in number
) AS
v_final_grade NUMBER;
Begin
--1. Calculate Final Grade ---
SELECT (assignment_score * p_assignment_weight) + (midterm_score * p_midterm_weight) + (final_score * p_final_weight)
INTO v_final_grade
FROM students
WHERE student_id = p_student_id;
--2. Update the final grade in Students Table --
UPDATE students
SET final_grade = v_final_grade
Where student_id = p_student_id;
Commit;
DBMS_OUTPUT.PUT_LINE('Final grade updated for student ID' || p_student_id ||' is:'||v_final_grade);
EXCEPTION
WHEN NO_DATA_FOUND THEN
DBMS_OUTPUT.PUT_LINE('Student not found.');
WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('An Error occurred:' || SQLERRM);
ROLLBACK;
End;
/

set serveroutput on
Begin
	calculate_final_grade(1, 0.3, 0.3, 0.4);
End;
/

Select * From students;


Begin
	calculate_final_grade(2, 0.3, 0.3, 0.4);
End;
/

Select * From students;



Begin
	calculate_final_grade(3,0.3, 0.3, 0.4);
End;
/

Select * From students;


Begin
	calculate_final_grade(4,0.3, 0.3, 0.4);
End;
/





#Question 2: 

Write a Java Program to read and display the contents of the file. 
