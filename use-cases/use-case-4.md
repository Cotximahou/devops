# USE CASE: 4 Add a New Employee’s Details

## CHARACTERISTIC INFORMATION

### Goal in Context
As an *HR advisor* I want *to add a new employee's details* so that *I can ensure the new employee is paid.*

### Scope
Company.

### Level
Primary task.

### Preconditions
HR system is accessible. New employee information is available.

### Success End Condition
Employee is added, and payroll is updated.

### Failed End Condition
Employee is not added.

### Primary Actor
HR Advisor.

### Trigger
A new employee joins the company.

## MAIN SUCCESS SCENARIO
1. HR advisor collects new employee information.
2. HR advisor enters employee details into the HR system.
3. System verifies and stores employee information.
4. Employee is now set up in payroll.

## EXTENSIONS
3. **Employee ID already exists**:
    1. System informs HR advisor to resolve duplication.

## SUB-VARIATIONS
None.
## SCHEDULE

**DUE DATE**: Release 1.0