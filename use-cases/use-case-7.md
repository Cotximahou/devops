
# USE CASE: 6 Update an Employee’s Details

## CHARACTERISTIC INFORMATION

### Goal in Context
As an *HR advisor* I want *to update an employee's details* so that *employee's details are kept up-to-date.*

### Scope
Company.

### Level
Primary task.

### Preconditions
HR system contains employee records. Employee ID is known.

### Success End Condition
Employee details are updated in the system.

### Failed End Condition
Employee details are not updated.

### Primary Actor
HR Advisor.

### Trigger
HR needs to update an employee's information.

## MAIN SUCCESS SCENARIO
1. HR advisor enters employee ID into HR system.
2. HR advisor updates necessary details.
3. System saves the updated information.
4. Employee details are now current.

## EXTENSIONS
2. **Employee ID not found**:
    1. System informs HR advisor no record exists.

## SUB-VARIATIONS
None.

## SCHEDULE

**DUE DATE**: Release 1.0