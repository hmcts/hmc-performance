Gatling HMC performance tests for HMC

The repo contains scenarios for 

	/*===============================================================================================
	 Data Prep
	 ===============================================================================================*/
1. CreateHMCUser - Create a User in IDAM with caseworker, caseworker-sscs, listed-hearing-viewer, caseworker-sscs-superuser, hearing-viewer, hearing-manager
HM
2. UserAssignments - Assigns user roles in access mgt for the user
3. CreateAppealCase - Creates a new case 


/*===============================================================================================
Scenario
===============================================================================================*/

1. 


To run the test:
1. Ensure that Gradle and Gatling are installed on your machine.
2. Clone the repo down using 'git clone https://github.com/hmcts/paybubble-performance-tests.git'.
3. Run it using 'gradle gatlingRun'.
