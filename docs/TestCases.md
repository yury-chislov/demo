# Test cases

## Create tasks and check results

This test uses list of different task names from `com.testing.webautomation.base.TestData` that possibly could cause an issue. It includes different languages, special characters and symbols
#####Steps:
- Create multiple tasks (one by one) 
- refresh browser
- Check all the tasks have been created
- Check if the number of tasks is correct (displayed in the lower left corner)

## Rename created tasks and check results

**Important** This test fails on purpose. I believe there is a bug on this site as after I rename a task and save it by pressing "Enter" or focusing out from the box, the task is renamed but the name is not saved if to refresh browser! The test would pass if this bug will be fixed. 
#####Steps:
- Create
- Rename task
- Check the task's name has changed
- Check number of items left = 1
- refresh browser and check the task's name again
- Check number of items left = 1 again


## Delete task and check results

#####Steps:
- Create task
- delete a task using the "x" button that appears when you hover the cursor over the task
- check there is no tasks, no task counter and no clear completed button displayed
- refresh browser
- check there is no tasks, no task counter and no clear completed button displayed


## Complete task and check results

#####Steps:
- Create 2 tasks
- Check number of items left = 2
- Complete the first task
- refresh browser
- Check number of items left = 1

## Clear completed tasks and check results

#####Steps:
- Create task
- Check number of items left = 1
- Click "complete task"
- Check number of items left = 0
- Click "clear completed" button
- refresh browser
- check there is no tasks, no task counter and no clear completed button displayed


##  Attempt to click 'clear completed' when nothing completed

#####Steps:
- Create new task
- refresh browser
- Check "clear completed" button is not displayed
- Check "clear completed" button is not clickable

##  Attempt to create Empty Task and check results
This test uses list of different variation of whitespaces `com.testing.webautomation.base.TestData`. The goal is to test the robustness of the system against invalid values.


#####Steps:
- Try to create multiple tasks (one by one) with variation of whitespaces
- refresh browser
- check there is no tasks, no task counter and no clear completed button displayed


##  Attempt to create task with disabled cookies
**Important** This test passes however the framework catches error in the error log that show the site doesn't handle this case appropriately.

#####Steps:
- Start browser session with disabled cookies
- Create new task
- refresh browser 
- check there is no tasks, no task counter and no clear completed button displayed (This expectation is debatable though)

##  Attempt to rename a task, but don't save the new name and check results

#####Steps:
- Create new task
- Rename task, but don't save it (don't press "Enter" or focus out of the task name box)
- refresh browser
- Check the new name is not applied and the original task name remain