
# USE CASE: 5 View an Employee’s Details

## CHARACTERISTIC INFORMATION

### Goal in Context
As an *HR advisor* I want *to view an employee's details* so that *the employee's promotion request can be supported.*

### Scope
Company.

### Level
Primary task.

### Preconditions
HR system contains employee records. Employee ID is known.

### Success End Condition
HR advisor can access employee details.

### Failed End Condition
Employee details cannot be retrieved.

### Primary Actor
HR Advisor.

### Trigger
Employee requests promotion or HR needs to verify information.

## MAIN SUCCESS SCENARIO
1. HR advisor enters employee ID into HR system.
2. System retrieves employee information.
3. HR advisor reviews employee details to support promotion request.

## EXTENSIONS
2. **Employee ID not found**:
    1. System informs HR advisor no record exists.

## SUB-VARIATIONS
None.

## SCHEDULE

**DUE DATE**: Release 1.0