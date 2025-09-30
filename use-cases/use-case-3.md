# USE CASE: 3 Produce a Report on the Salary of Employees in My Department

## CHARACTERISTIC INFORMATION

### Goal in Context
As a *department manager* I want *to produce a report on the salary of employees in my department* so that *I can support financial reporting for my department.*

### Scope
Department.

### Level
Primary task.

### Preconditions
Database contains current employee salary data. Manager has access to their department’s data.

### Success End Condition
A report is available for the manager to provide for departmental reporting.

### Failed End Condition
No report is produced.

### Primary Actor
Department Manager.

### Trigger
Manager requests a salary report for their department.

## MAIN SUCCESS SCENARIO
1. Manager requests salary information for their department.
2. System identifies the department associated with the manager.
3. System extracts current salary information for all employees in that department.
4. Manager receives report.

## EXTENSIONS
None.

## SUB-VARIATIONS
None.

## SCHEDULE

**DUE DATE**: Release 1.0