
# USE CASE: 2 Produce a Report on the Salary of Employees in a Department

## CHARACTERISTIC INFORMATION

### Goal in Context
As an *HR advisor* I want *to produce a report on the salary of employees in a department* so that *I can support financial reporting of the organisation.*

### Scope
Company.

### Level
Primary task.

### Preconditions
Database contains current employee salary data. Department exists.

### Success End Condition
A report is available for HR to provide to finance.

### Failed End Condition
No report is produced.

### Primary Actor
HR Advisor.

### Trigger
A request for finance information is sent to HR.

## MAIN SUCCESS SCENARIO
1. Finance requests salary information for a given department.
2. HR advisor captures the department name.
3. HR advisor extracts current salary information for all employees in that department.
4. HR advisor provides report to finance.

## EXTENSIONS
3. **Department does not exist**:
    1. HR advisor informs finance that the department does not exist.

## SUB-VARIATIONS
None.

## SCHEDULE

**DUE DATE**: Release 1.0