CREATE TABLE demo(demoID INT NOT NULL CONSTRAINT P_DEMOID PRIMARY KEY IDENTITY(1,1),demoname VARCHAR(50) NOT NULL)
CREATE TABLE Doctor(DoctorID INT NOT NULL CONSTRAINT P_DOCTORID PRIMARY KEY IDENTITY(1,1),DoctorName VARCHAR(50) NOT NULL)
CREATE TABLE Users(UserID INT NOT NULL CONSTRAINT PP_USER PRIMARY KEY IDENTITY(1,1),UserName VARCHAR(50) NOT NULL,Password VARCHAR(50) NOT NULL)
CREATE TABLE AccNanny(Acc_ID INT NOT NULL CONSTRAINT PK_ACCNANNY PRIMARY KEY IDENTITY(1,1),Acc_NannyName VARCHAR(50) NOT NULL,Acc_Password VARCHAR(50) NOT NULL)
CREATE TABLE Groups(GroupsName VARCHAR(50)NOT NULL CONSTRAINT P_GROUPSNAME PRIMARY KEY,ChargesPerGroups INT DEFAULT(0))
CREATE TABLE Groups_Actitive(ActitiviesID INT NOT NULL CONSTRAINT P_ACTID PRIMARY KEY IDENTITY(1,1),GroupsName VARCHAR(50) NOT NULL,ActivitiesPerGroups VARCHAR(50) DEFAULT(''),TimeActivities VARCHAR(50) NOT NULL,CONSTRAINT FK_GROUPSNAME FOREIGN KEY(GroupsName) REFERENCES Groups)
CREATE TABLE Nanny(NannyID INT NOT NULL CONSTRAINT PK_NANNYID PRIMARY KEY IDENTITY(1,1),NannyName VARCHAR(50) NOT NULL,Address VARCHAR(50) NOT NULL,ContactNumber INT NOT NULL,Charges INT NOT NULL,Workinghours INT NOT NULL)
CREATE TABLE Children(ChildID INT NOT NULL CONSTRAINT PK_CHILDID PRIMARY KEY IDENTITY(1,1),LastName VARCHAR(50) NOT NULL,FirstName VARCHAR(50) NOT NULL,MiddleName VARCHAR(50) NOT NULL,Birthday VARCHAR(50) NOT NULL,ParentName VARCHAR(50) NOT NULL,ParentWorkNumber INT DEFAULT(0),ParentMobileNumber INT NOT NULL,ParentEmailAddress VARCHAR(50) DEFAULT(''),NextOfKin VARCHAR(50) DEFAULT(''),DoctorName VARCHAR(50) NOT NULL,NannyName VARCHAR(50) NOT NULL,GroupsName VARCHAR(50) NOT NULL,CONSTRAINT FK_GroupsName1 FOREIGN KEY(GroupsName) REFERENCES Groups)
CREATE TABLE PastIllness(ChildID INT NOT NULL,TypeofIllness VARCHAR(50) DEFAULT(''),DateStart VARCHAR(50) DEFAULT(''),DateEnd VARCHAR(50) DEFAULT(''),CONSTRAINT FK_CHILDID FOREIGN KEY(ChildID) REFERENCES Children)
CREATE TABLE Medication(ChildID INT NOT NULL,MedicationName VARCHAR(50) DEFAULT(''),Dosge VARCHAR(50) DEFAULT('')CONSTRAINT FK_MEDICATION_CHILDID FOREIGN KEY(ChildID) REFERENCES Children)
INSERT INTO Users(UserName,Password) VALUES ('admin','admin')
CREATE PROCEDURE spGetAll AS SELECT * FROM Children  
CREATE PROCEDURE spInsertChildren  @Child_LastName VARCHAR(200),@Child_FirstName VARCHAR(50),@Child_MiddleName VARCHAR(50),@Child_Birthday VARCHAR(50),@Child_ParentName VARCHAR(50),@Child_ParentWorkNumber INT,@Child_ParentMobileNumber INT,@Child_ParentEmailAddress varchar(50),@Child_NextOfKin varchar(50),@Child_DoctorName varchar(50),@Child_NannyName VARCHAR(50),@Child_GroupsName VARCHAR(50) AS INSERT INTO Children(LastName,FirstName,MiddleName,Birthday,ParentName,ParentWorkNumber,ParentMobileNumber,ParentEmailAddress,NextOfKin,DoctorName,NannyName,GroupsName)VALUES(@Child_LastName,@Child_FirstName,@Child_MiddleName,@Child_Birthday,@Child_ParentName,@Child_ParentWorkNumber,@Child_ParentMobileNumber,@Child_ParentEmailAddress,@Child_NextOfKin,@Child_DoctorName,@Child_NannyName,@Child_GroupsName)
CREATE PROCEDURE spUpdateChildren @Child_ID INT,@Child_LastName VARCHAR(50),@Child_FirstName VARCHAR(50),@Child_MiddleName VARCHAR(50),@Child_Birthday VARCHAR(50),@Child_ParentName VARCHAR(50),@Child_ParentWorkNumber int,@Child_ParentMobileNumber int,@Child_ParentEmailAddress varchar(50),@Child_NextOfKin varchar(50),@Child_DoctorName varchar(50),@Child_NannyName VARCHAR(50),@Child_GroupsName VARCHAR(50) AS UPDATE Children SET LastName=@Child_LastName,FirstName=@Child_FirstName,MiddleName=@Child_MiddleName,Birthday=@Child_Birthday,ParentName=@Child_ParentName,ParentWorkNumber=@Child_ParentWorkNumber,ParentMobileNumber=@Child_ParentMobileNumber,ParentEmailAddress=@Child_ParentEmailAddress,NextOfKin=@Child_NextOfKin,DoctorName=@Child_DoctorName,NannyName=@Child_NannyName,GroupsName=@Child_GroupsName WHERE ChildID=@Child_ID
CREATE PROCEDURE spDeleteChildren @Child_ID INT AS DELETE FROM Children WHERE ChildID=@Child_ID
CREATE PROCEDURE spSetByID @Child_LastName VARCHAR(50),@Child_FirstName VARCHAR(50),@Child_ParentName VARCHAR(50) AS SELECT ChildID FROM Children WHERE (LastName=@Child_LastName) and (FirstName=@Child_FirstName)and (ParentName=@Child_ParentName)
CREATE PROCEDURE spGetAllByFirstName @FirstName VARCHAR(50) AS SELECT * FROM Children WHERE FirstName like @FirstName
CREATE PROCEDURE spGetAllByLastName @LastName VARCHAR(50) AS SELECT * FROM Children WHERE LastName like @LastName
CREATE PROCEDURE spGetAllByBirthday @Birthday VARCHAR(50) AS SELECT * FROM Children WHERE Birthday like @Birthday
CREATE PROCEDURE spGetAllByGrName @GrName VARCHAR(50) AS SELECT * FROM Children WHERE GroupsName=@GrName
CREATE PROCEDURE spInsertNanny  @Nanny_Name VARCHAR(50),@Nanny_Address VARCHAR(50),@Nanny_ContactNumber INT,@Nanny_Charges INT,@Nanny_Workinghours INT AS INSERT INTO Nanny(NannyName,Address,ContactNumber,Charges,Workinghours)VALUES(@Nanny_Name,@Nanny_Address,@Nanny_ContactNumber,@Nanny_Charges,@Nanny_Workinghours)
CREATE PROCEDURE spUpdateNanny @Nanny_ID INT,@Nanny_Name VARCHAR(50),@Nanny_Address VARCHAR(50),@Nanny_ContactNumber INT,@Nanny_Charges INT,@Nanny_Workinghours INT AS UPDATE Nanny SET NannyName=@Nanny_Name,Address=@Nanny_Address,ContactNumber=@Nanny_ContactNumber,Charges=@Nanny_Charges,Workinghours=@Nanny_Workinghours WHERE NannyID=@Nanny_ID
CREATE PROCEDURE spDeleteNanny @Nanny_ID INT AS DELETE FROM Nanny WHERE NannyID=@Nanny_ID
CREATE PROCEDURE spGetAllNanny AS SELECT * FROM Nanny
CREATE PROCEDURE spGetNannyID @NannyName VARCHAR(50) AS SELECT NannyID FROM Nanny WHERE NannyName=@NannyName
CREATE PROCEDURE spGetbyNannyName @NannyName VARCHAR(50) AS SELECT * FROM Nanny WHERE NannyName=@NannyName
CREATE PROCEDURE spGetAllByNannyName @NannyName VARCHAR(50) AS SELECT * FROM Children WHERE NannyName=@NannyName
CREATE PROCEDURE spGetNannyName AS SELECT NannyName FROM Nanny
CREATE PROCEDURE spInsertPastIllness  @ChildID INT,@Past_Name VARCHAR(50),@Past_DateStart VARCHAR(50),@Past_DateEnd VARCHAR(50) AS INSERT INTO PastIllness(ChildID,TypeofIllness,DateStart,DateEnd)VALUES(@ChildID,@Past_Name,@Past_DateStart,@Past_DateEnd)
CREATE PROCEDURE spUpdatePastIllness @Child_ID INT,@Past_Name VARCHAR(50),@Past_DateStart VARCHAR(50),@Past_DateEnd VARCHAR(50) AS UPDATE PastIllness SET TypeofIllness=@Past_Name,DateStart=@Past_DateStart,DateEnd=@Past_DateEnd WHERE ChildID=@Child_ID
CREATE PROCEDURE spDeletePastIllness @Child_ID INT AS DELETE FROM PastIllness WHERE ChildID=@Child_ID
CREATE PROCEDURE spGetAllByChildID @Child_ID INT AS SELECT * FROM PastIllness WHERE ChildID=@Child_ID
CREATE PROCEDURE spGetPastIllness AS SELECT * FROM PastIllness
CREATE PROCEDURE spDelByChildID @ChildID INT AS DELETE FROM PastIllness WHERE ChildID=@ChildID
CREATE PROCEDURE spInsertDoctor  @DoctorName VARCHAR(50) AS INSERT INTO Doctor(DoctorName)VALUES(@DoctorName)
CREATE PROCEDURE spUpdateDoctor @Doctor_ID INT,@DoctorName VARCHAR(50) AS UPDATE Doctor SET DoctorName=@DoctorName WHERE DoctorID=@Doctor_ID
CREATE PROCEDURE spDeleteDoctor @Doctor_ID INT AS DELETE FROM Doctor WHERE DoctorID=@Doctor_ID
CREATE PROCEDURE spGetDoctor AS SELECT * FROM Doctor
CREATE PROCEDURE spGetDoctorName AS SELECT DoctorName FROM Doctor
CREATE PROCEDURE spGetAccNannyByName @Acc_NannyName VARCHAR(50) AS SELECT * FROM AccNanny WHERE Acc_NannyName=@Acc_NannyName
CREATE PROCEDURE spGetIDByName @DoctorName VARCHAR(50) AS SELECT DoctorID FROM Doctor WHERE DoctorName=@DoctorName
CREATE PROCEDURE spInsertGroups  @GroupsName VARCHAR(50),@ChargesPerGroups INT AS INSERT INTO Groups(GroupsName,ChargesPerGroups)VALUES(@GroupsName,@ChargesPerGroups)
CREATE PROCEDURE spUpdateGroups @GroupsName VARCHAR(50),@ChargesPerGroups INT AS UPDATE Groups SET ChargesPerGroups=@ChargesPerGroups WHERE GroupsName=@GroupsName
CREATE PROCEDURE spDeleteGroups @GroupsName VARCHAR(50) AS DELETE FROM Groups WHERE GroupsName=@GroupsName
CREATE PROCEDURE spGetAllGroups AS SELECT * FROM Groups
CREATE PROCEDURE spGetGroupsName AS SELECT GroupsName FROM Groups
CREATE PROCEDURE spInsertGroupsActive  @GroupsName VARCHAR(50),@ActivitiesPerGroups VARCHAR(50),@TimeActivities VARCHAR(50) AS INSERT INTO Groups_Actitive(GroupsName,ActivitiesPerGroups,TimeActivities)VALUES(@GroupsName,@ActivitiesPerGroups,@TimeActivities)
CREATE PROCEDURE spUpdateGroupsActive @ActitiviesID INT,@GroupsName VARCHAR(50),@ActivitiesPerGroups VARCHAR(50),@TimeActivities VARCHAR(50) AS UPDATE Groups_Actitive SET GroupsName=@GroupsName,ActivitiesPerGroups=@ActivitiesPerGroups,TimeActivities=@TimeActivities WHERE ActitiviesID=@ActitiviesID
CREATE PROCEDURE spDeleteGroupsActive @ActitiviesID INT AS DELETE FROM Groups_Actitive WHERE ActitiviesID=@ActitiviesID
CREATE PROCEDURE spGetGroupsActiveAll AS SELECT * FROM Groups_Actitive
CREATE PROCEDURE spSetByIDAtv @GroupsName VARCHAR(50),@Action VARCHAR(50) AS SELECT ActitiviesID FROM Groups_Actitive WHERE (GroupsName=@GroupsName)and(ActivitiesPerGroups=@Action)
CREATE PROCEDURE spGetAllByAtvID @GrName VARCHAR(50) AS SELECT ActitiviesID,GroupsName,ActivitiesPerGroups,TimeActivities FROM Groups_Actitive WHERE GroupsName=@GrName
CREATE PROCEDURE spInsertMedication  @ChildID INT,@MedicationName VARCHAR(50),@Dosage VARCHAR(50) AS INSERT INTO Medication(ChildID,MedicationName,Dosge)VALUES(@ChildID,@MedicationName,@Dosage)
CREATE PROCEDURE spUpdateMedication @ChildID INT,@MedicationName VARCHAR(50),@Dosage VARCHAR(50) AS UPDATE Medication SET MedicationName=@MedicationName,Dosge=@Dosage WHERE ChildID=@ChildID
CREATE PROCEDURE spDeleteMedication @ChildID INT  AS DELETE FROM Medicatioon WHERE ChildID=@ChildID
CREATE PROCEDURE spGetAllMedicationByChildID @Child_ID INT AS SELECT * FROM Medication WHERE ChildID=@Child_ID
CREATE PROCEDURE spDelMediByChildID @ChildID INT AS DELETE FROM Medication WHERE ChildID=@ChildID
CREATE PROCEDURE spGetusersAll AS SELECT * FROM Users
CREATE PROCEDURE spInsertUsers @UserName VARCHAR(50),@UserPass VARCHAR(50) AS INSERT INTO Users(UserName,Password) VALUES (@UserName,@UserPass)
CREATE PROCEDURE spDeleteUser @UserID INT AS DELETE FROM Users WHERE UserID=@UserID
CREATE PROCEDURE spGetAdminByName @UserName VARCHAR(50) AS SELECT * FROM Users WHERE UserName=@UserName
CREATE PROCEDURE spUpdateUsers @UserID INT,@UserName VARCHAR(50),@UserPass VARCHAR(50) AS UPDATE Users SET UserName=@UserName,Password=@UserPass
CREATE PROCEDURE spInsertAccNany @Acc_NannyName VARCHAR(50),@Acc_Password VARCHAR(50) AS INSERT INTO AccNanny(Acc_NannyName,Acc_Password) VALUES(@Acc_NannyName,@Acc_Password)
CREATE PROCEDURE spDeleteAccNanny @AccID INT AS DELETE FROM AccNanny WHERE Acc_ID=@AccID
CREATE PROCEDURE spUpdateAccNanny @AccID INT,@AccNannyName VARCHAR(50),@AccPassword VARCHAR(50) AS UPDATe AccNanny SET Acc_NannyName=@AccNannyName,Acc_Password=@AccPassword WHERE Acc_ID=@AccID
CREATE PROCEDURE spGetAccNannyAll AS SELECT * FROM AccNanny
