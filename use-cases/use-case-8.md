# USE CASE: 7 Delete an Employee’s Details

## CHARACTERISTIC INFORMATION

### Goal in Context
As an *HR advisor* I want *to delete an employee's details* so that *the company is compliant with data retention legislation.*

### Scope
Company.

### Level
Primary task.

### Preconditions
HR system contains employee records. Employee ID is known. Legal retention period has expired.

### Success End Condition
Employee details are removed from the system.

### Failed End Condition
Employee details are not deleted.

### Primary Actor
HR Advisor.

### Trigger
HR needs to remove an employee’s record after retention period.

## MAIN SUCCESS SCENARIO
1. HR advisor identifies the employee to delete.
2. HR advisor confirms deletion criteria are met.
3. HR advisor deletes employee record from the system.
4. System confirms record removal.

## EXTENSIONS
2. **Employee ID not found**:
    1. System informs HR advisor no record exists.

3. **Retention period not met**:
    1. System prevents deletion and alerts HR advisor.

## SUB-VARIATIONS
None.

## SCHEDULE

**DUE DATE**: Release 1.0