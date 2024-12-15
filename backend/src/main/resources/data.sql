-- Clear existing tasks and to-do lists
DELETE FROM Task;
DELETE FROM ToDoList;

-- Insert ToDoLists
INSERT INTO ToDoList (title) VALUES ('Groceries');
INSERT INTO ToDoList (title) VALUES ('Work');
INSERT INTO ToDoList (title) VALUES ('Home');

-- Get the IDs of the inserted ToDoLists
-- Assuming the IDs are auto-incremented and start from 1
-- You may need to adjust this based on your actual database setup
SELECT id INTO @groceries_id FROM ToDoList WHERE title = 'Groceries';
SELECT id INTO @work_id FROM ToDoList WHERE title = 'Work';
SELECT id INTO @home_id FROM ToDoList WHERE title = 'Home';

-- Insert Tasks
INSERT INTO Task (title, description, status, todo_list_id) VALUES ('Buy milk', 'Go to the store and buy milk', 'Pending', @groceries_id);
INSERT INTO Task (title, description, status, todo_list_id) VALUES ('Clean the house', 'Clean the house before the guests arrive', 'Pending', @home_id);
INSERT INTO Task (title, description, status, todo_list_id) VALUES ('Finish the project', 'Finish the project before the deadline', 'Pending', @work_id);