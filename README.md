# Task CLI Application

This is a simple command-line interface (CLI) application for task management. It allows you to add, update, delete, mark, and list tasks directly from the terminal. All tasks are stored in a `.json` file, so you can resume working with the app even after closing and restarting the session.

## Features

- Add a task: add a new task with a description;
- Update a task: update the description of an existing task;
- Delete a task: remove a task by its ID;
- Mark a task as: mark a task as `in-progress` or `done`;
- List tasks: list all tasks or filter them by status (`todo`, `in-progress`, `done`);
- List all commands.

## Requirements

- Java 8 or higher
- Git (optional, for cloning)

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/justfloer/TaskTracker
   cd TaskTracker/src

2. Make sure you're on the `master` branch

   ```bash
   git checkout master
   
3. Compile the source code:

   ```bash
   javac TaskCli.java

4. Run the application:

   ```bash
   java TaskCli <command> [arguments]

## Ccommands and usage

```bash
# Adding a new task
java TaskCli add "Buy groceries"
# Output: Task added successfully (ID: 1)

# Updating a task
java TaskCli update 1 "Buy groceries and cook dinner"
# Output: Successfully updated task (ID: 1)

# Deleting a task
java TaskCli delete 1
# Output: Successfully deleted task (ID: 1)

# Marking a task as in-progress
java TaskCli mark-in-progress 1
# Output: Successfully marked as in progress task (ID: 1)

# Marking a task as done
java TaskCli mark-done 1
# Output: Successfully marked done task (ID: 1)

# Listing all tasks
java TaskCli list
# Output: 'List of all tasks'

# Listing tasks by status
java TaskCli list done
java TaskCli list todo
java TaskCli list in-progress
# Output: 'List of all tasks with the requested status'

# See the list of all commands available
java TaskCli commands
# Output: 'List of all commands available'
```
