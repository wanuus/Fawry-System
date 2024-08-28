1)JavaSE-17
2)Maven
3)TomCat
4)PostMan
----------------------------------------------------------
To Start The project in Eclipse : 
1-Start Eclipse
2-Select file->import->maven->Existing maven projects
3-click next
4-choose FawrySystem Folder of our Submission
5-make sure the box of /pom.xml is clicked
6-Finish
------------------------------------------------------
To Run :
1)open the main FawrySystemApplication.java
2)Run as spring Boot app
------------------------------------------------------------------------------------------------------
To use any Features of User the User must be signed in otherwise the System will ask him to go sign in
------------------------------------------------------------------------------------------------------
To Sign up :
Link : http://localhost:8080/UserController/signup (POST)
json body :
-------------------------------
{
    "email": "Hassan@gmail.com",
    "password": "BestTAxD",
    "username": "Hassan"
       
}
---------------------------------
To Sign in :
Link : http://localhost:8080/UserController/signin (GET)
info must be prams in link like if using post man :
---------------------------------------------------
	key		value
	email		Hassan@gmail.com
	password	BestTAxD

OR : http://localhost:8080/UserController/signin?email=Hassan@gmail.com&password=BestTAxD
-----------------------------------------------------------------------------------------
To Add Credit Card to User's Account:
Link : http://localhost:8080/CreditCardController/AddCreditCard (POST)
json body :
----------------------------------
{

    "creditCardNumber":"12345",
    "creditCardPassword":"1010",
    "avalAmount":22000 

}
------------------------------------
To add Credit To wallet :
Link : http://localhost:8080/WalletController/AddWallet (POST)
json body :
------------------------------
{
    "amount" : 200
}
-------------------------------
This amount will be taken from the credit card so if there is no enough value the system won't proceed the adding.
------------------------------------------------------------------------------------------------------------------
Pay for a service :
Link : http://localhost:8080/PaymentController/Pay (POST)
json body: 
{
	"method" : "creditcard",
	"amount" : 200,
	"provider" : "We",
 	"mobilenumber" : "01124046025"
}
OR 
{
	"method" : "wallet",
	"amount" : 200,
	"provider" : "We",
	"mobilenumber" : "01124050"
}
or
{
    "method":"CreditCard",
    "provider":"MonthlyReceipt",
    "mobilenumber":"1234567",
    "amount":100,
    "address":"giza"
}

Methods are -> "wallet" OR "creditcard"
Providers are -> "Vodafone" , "We" , "Orange" , "Etisalat" , "NGOsDonations" , "SchoolDonations" , "CancerHospitalDonations" , "MonthlyReceipt" , "QuarterReceipt"
Dicounts are added automatically 
"Vodafone" , "We" , "Orange" , "Etisalat" take->mobilenumber and amount from user.
"NGOsDonations" , "SchoolDonations" , "CancerHospitalDonations" take->amount from user.
"MonthlyReceipt" , "QuarterReceipt" take->address,mobilenumber and amount from user.
--------------------------------------------------------------------------------------------------------------------------------------------------------------------
To make a refund Request :
Link : http://localhost:8080/RefundController/request (POST)
json body:
{
	"amount": 100,
    	"reason" : "TIRED"
}
-----------------------------------------------------------------
to veiw Discounts:
------------------
http://localhost:8080/DiscountController/VeiwDiscounts (GET)
-----------------------------------------------------------------
to search for services:
-----------------------
http://localhost:8080/UserController/Search?Search=V (Get)
or
http://localhost:8080/UserController/Search (GET)
        key	  value
	Search    V
-----------------------------------------------------------------
To Sign out :
-------------
http://localhost:8080/UserController/signout?exit=Signout(POST)
or
http://localhost:8080/UserController/signout (POST)
        key	  value
	exit      Signout
-----------------------------------------------------------------
Admin Features :
----------------
To sign in:
http://localhost:8080/AdminController/signin?password=btates (GET)
OR 
http://localhost:8080/AdminController/signin (GET)
	key	  value
	password  btates
-------------------------------------------------------------------
To view Transactions:
Link : http://localhost:8080/Transactions/View (GET)
-------------------------------------------------------------------
To view Refund Requests :
Link : http://localhost:8080/RefundController/ViewReq (GET)
-------------------------------------------------------------------
To Sign out :
-------------
http://localhost:8080/AdminController/signout?exit=Signout(POST)
or
http://localhost:8080/AdminController/signout (POST)
        key	  value
	exit      Signout
--------------------------------------------------------------------
to add Overall discount:
------------------------
http://localhost:8080/DiscountController/AddOverAllDiscount (POST)
{
    "discount":5
}
overall discount is one discount only for al services
when adding new overall discount it replaces old one.
-------------------------------------------------------------------
to add Specific discount:
------------------------
http://localhost:8080/DiscountController/AddSpecificDiscount (POST)
{
    "service":"MonthlyReceipt",
    "discount":20
}
--------------------------------------------------------------------
To Approve or rejeict a refund request:
Admin must first see the id of this request throught he view refund request 
then :
Link : http://localhost:8080/RefundController/HandelRefund (GET)
	key 	value
	ID	1
	status	Approve
http://localhost:8080/RefundController/HandelRefund?Id=1&status=Approve
OR
key 	value
	ID	1
	status	Reject
-----------------------------------------------------------------------
