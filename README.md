Gatling HMC performance tests for HMC

The repo contains scenarios for 

	/*===============================================================================================
	 Data Prep - User Creation
	 ===============================================================================================*/
1. CreateHMCUser - Create a User in IDAM with caseworker, caseworker-sscs, listed-hearing-viewer, caseworker-sscs-superuser, hearing-viewer, hearing-manager
HM
2. UserAssignments - Assigns user roles in access mgt for the user


   /*===============================================================================================
   Data Prep - Case Creation
   ===============================================================================================*/
3. CreateAppealCase - Creates a new SSCS case.  
   A) Output -  HMCAppeals.csv - created Cases are output to this file
   B) Input - NINumber.csv -  each appeal requires a unique NI number.    

   /*===============================================================================================
   Data Prep - Scenario Prep - you will need to get records in a certain state so you can View, 
   Update, Delete, Hearing on cases
   ===============================================================================================*/
5. RequestHearing - adds a Hearing to a case
   A) Output - HearingDetails.csv - Case Ref and Hearing Ref will be outout here - 
   B) Input - RequestHearing.csv - feeds in the Case Ref
   C) Test Setup - 
   1. RequestHearing.csv - feeds case ref data required for request hearing
   2. UpdateHearing.csv - feeds case ref and hearing ref data required for Updating a Hearing.  
   This also feeds data for Delete Hearing....once a hearing is updated it will be deleted. as a result
   this file needs to be updated after each run.
   3. 


         /*===============================================================================================
      Scenario
      ===============================================================================================*/

7. 


To run the test:
1. Ensure that Gradle and Gatling are installed on your machine.
2. Clone the repo down using 'git clone https://github.com/hmcts/paybubble-performance-tests.git'.
3. Run it using 'gradle gatlingRun'.
