#include<iostream>
#include<conio.h>
#include<string>
#include<fstream>
using namespace std;
struct login
{
	string User_Name;
	string Password;
};

login Account = { "M Saqib", "project" };


struct product {
	int product_number;
	string product_name;
	float product_price;
	float product_quantity;
	float product_discount;
};

void Menu();
void customer();
void admin_menu();
void admin_login();
void user_login();
void create_product();
void display_product();
void modify_product();
void delete_product();






int i = 5;
char character;
int counter = 5;
int cdelete = 0;
float price, total, tax, paid, Balance, quantity;

product pr[10]{ { 1, "juice", 30, 15, 3 },
{ 2, "chips", 20, 20, 3 },
{ 3, "milk", 130, 15, 3 },
{ 4, "coke", 100, 15, 3 },
{ 5, "jam", 240, 15, 3 } };

product bill[10];
int num, j = 0, sr; char choice;
string s[500];

void customer()
{
	product bill[10];
	int num, j = 0, sr; char choice;

	cout << "\n\n\n\t ---------------------------  WEL COME for SHOPPING  ---------------------------- " << endl;
	cin.ignore();
	display_product();

	do
	{
		cout << "\n\n\n\t Enter the product u want to buy " << endl;
		cin >> num;
		i = num - 1;
		price = pr[i].product_price;
		do
		{
			cout << "Enter the quantity of product " << endl;
			cin >> quantity;
			if (quantity <= pr[i].product_quantity)
			{
				total = total + price*quantity;

			}
			else {
				cout << "Sorry!!....quantity of product is not more than " << pr[i].product_quantity << endl;
			}
			cout << "\n Press y if u change the quantity " << endl;
			cin >> choice;
		} while (choice == 'y' || choice == 'Y');
		pr[i].product_quantity = pr[i].product_quantity - quantity;
		//Code for Bill........
		bill[j].product_number = j + 1;
		bill[j].product_name = pr[i].product_name;
		cin.ignore();
		bill[j].product_price = pr[i].product_price;
		bill[j].product_quantity = pr[i].product_quantity;
		bill[j].product_discount = pr[i].product_discount;
		sr = bill[j].product_number;
		j++;
		//Code end......
		cout << " \n Press Y if you want to Continue : (Y/N) ";
		cin >> choice;
	} while (choice == 'Y' || choice == 'y');
	//Display Bill List......
	cout << "\n\n\t\t-------------------------- Product list ------------------" << endl;
	cout << "\n\t " << "Product #" << "\t " << "Name" << "\t\t " << "Price" << "\t\t " << "Quantity" << "\t " << "Discount";

	for (int i = 0; i < sr; i++)
	{
		cout << "\n\n\t " << bill[i].product_number;
		cout << "\t\t " << bill[i].product_name;
		cout << "\t\t " << bill[i].product_price;
		cout << "\t\t " << bill[i].product_quantity;
		cout << "\t\t " << bill[i].product_discount;
	}



	cout << "\n\n\tTotal Bill of Product is   : " << total << endl;
	cout << "\n\t Enter Tax on Total Bill : ";
	cin >> tax;
	tax = total * tax / 100;
	total = total + tax;
	float k, v;
	cout << "\n\t Enter Discount on Total Bill : ";
	cin >> v;
	k = total * v / 100;
	total = total - k;


X:

	cout << "\n\n\tTotal Bill with Rs: " << tax << " tax  " << "and" << v << "% discount is : " << total << endl;

	cout << " \n\n\tPlease enter Cash for Bill ..... :";
	cin >> paid;
	if (paid >= total)
	{
		Balance = paid - total;
		cout << "\n\n\tYour Balance Amount is Rs: " << Balance << endl;
		cout << "\n\n\t --------------------------------  Thank for Shoping Here !!!  ---------------------------" << endl;
	}
	else
	{
		system("cls");
		cout << "\n\n\t Amount of bill is less than You Paid...... " << endl;
		cout << " \n\t Please Pay Full Amount ....." << endl;
		goto X;

	}
	ofstream write("record.txt", ios::app);
	for (int j = 0; j < sr; j++)
	{
		write << "the product number is" << bill[j].product_number << " \nname is " << bill[j].product_name << "price is:" << bill[j].product_price << "product quantity is:" << bill[j].product_quantity;
	}
	write.close();
	_getch();

}

int main()
{


	cout << "\n\n\n\n\t\t---------   WELCOME to   Our SUPER MART----------  \n\t\t\t\t\t\t \n\n\n\n" << endl;





	Menu();
	
	



	_getch();
	return 0;


}


void Menu()
{
	int option;
	cout << "\n\t__________________________________";
	cout << "\n\t 1.Customer";
	cout << "\n\t 2.Administrator";
	cout << "\n\t 3.Exit";
	cout << "\n\t___________________________________";
	cout << "\n\t Option : ";
	cin >> option;
	switch (option) {
	case 1:
		customer();
		system("cls");
		;
		break;
	case 2:
		system("cls");
		admin_login();

		break;
	case 3:
		system("cls");
		cout << "\n\n\n\n\n\t\t\t\t\t-----------  GOOD BYE....!! ------------";
		break;
	default:
		cout << "Invalid Option......!" << endl;
		break;
	}

}


void admin_menu()
{
	int Option;
	cout << "\n\t\t...................ADMIN MENU......................\n" << endl;
	cout << "\n\t______________________________________________________" << endl;
	cout << "\n\t PRESS 1 TO CREATE PRODUCT : " << endl;
	cout << "\n\t PRESS 2 TO DISPLAY ALL PRODUCT : " << endl;
	cout << "\n\t PRESS 3 TO MODIFY PRODUCT : " << endl;
	cout << "\n\t PRESS 4 TO DELETE PRODUCT : " << endl;
	cout << "\n\t PRESS 5 TO GO BACK TO MAIN MENU : " << endl;
	cout << "\n\t______________________________________________________" << endl;
	cout << "\n\n\t Option : " << endl;
	cin >> Option;
	switch (Option) {
	case 1:
		system("cls");
		create_product();
		break;
	case 2:
		system("cls");
		display_product();
		break;

	case 3:
		system("cls");
		modify_product();
		break;
	case 4:
		system("cls");
		delete_product();
		break;
	case 5:
		system("cls");
		Menu();
		break;
	default:
		system("cls");
		cout << "Invalid Option........." << endl;
		cout << "\n\n\t Please enter ur choice again......." << endl;
		admin_menu();
		break;
	}


}
void display_product()
{
	pr[10];

	system("cls");

	cout << "\n\n\t_____________________________ All Product List__________________________________" << endl << endl << endl;
	cout << "\n\t " << "Product #" << "\t " << "Name" << "\t\t " << "Price" << "\t\t " << "Quantity" << "\t" << "Discount";

	if (5<counter)
	{


		for (int i = 0; i < counter - cdelete; i++)
		{
			cout << "\n\n\t " << pr[i].product_number;
			cout << "\t\t " << pr[i].product_name;
			cout << "\t\t " << pr[i].product_price;
			cout << "\t\t " << pr[i].product_quantity;
			cout << "\t\t " << pr[i].product_discount;
		}
	}
	else {
		for (int i = 0; i < 5 - cdelete; i++)
		{
			cout << "\n\n\t " << pr[i].product_number;
			cout << "\t\t " << pr[i].product_name;
			cout << "\t\t " << pr[i].product_price;
			cout << "\t\t " << pr[i].product_quantity;
			cout << "\t\t " << pr[i].product_discount;
		}

	}
}
void delete_product()
{
	char Choice;
	int Num;

	cout << " \n\t\t -----------------------   Delete Product  ---------------------- " << endl;

	display_product();
	do
	{
		char a;
		do
		{
			cout << "\n\n Please Enter The Product # You Want to Delete : ";
			cin >> Num;
			cout << endl << "Product Name :" << pr[Num - 1].product_name;
			cout << endl << "Product Price :" << pr[Num - 1].product_price;
			cout << endl << "Product Stock :" << pr[Num - 1].product_quantity;
			cout << endl << "Product Discount : " << pr[Num - 1].product_discount << endl;
			cout << "\n\nAre you sure to Delete this Product Press Y  (Y/N): ";
			cdelete++;
			cin >> Choice;
			cout << "press n if u want to end deleting procedure" << endl;
			cin >> a;
		} while (a != 'n');

		if (Num - 1 < counter)
		{

			pr[counter].product_number = 0;
			for (int i = Num - 1; i < counter; i++)
			{

				pr[i].product_name = pr[i + 1].product_name;
				pr[i].product_price = pr[i + 1].product_price;
				pr[i].product_quantity = pr[i + 1].product_quantity;
				pr[i].product_discount = pr[i + 1].product_discount;
			}
			counter--;
		}
		else
		{

			pr[4].product_number = 0;
			for (int i = Num - 1; i < 5; i++)
			{
				pr[i].product_name = pr[i + 1].product_name;
				pr[i].product_price = pr[i + 1].product_price;
				pr[i].product_quantity = pr[i + 1].product_quantity;
				pr[i].product_discount = pr[i + 1].product_discount;

			}
			counter--;
		}
		cout << " \n\n Press Y if you want to Continue (Y/N)";
		cin >> Choice;
	} while (Choice == 'Y' || Choice == 'y');
	cout << "\n\n Press Y for Admin Menu and N for Main Menu " << endl;
	cout << "Option : ";
	cin >> character;
	if (character == 'Y' || character == 'y')
	{
		system("cls");
		admin_menu();
	}
	else
	{
		system("cls");
		Menu();
	}


}
void modify_product()
{

	display_product();

	char choice;

	cout << "\n\n\n\n\n\t -------------------------   Modify Product  -------------------------- " << endl;

	do
	{

		cout << "\n Enter the product u want to modify " << endl;
		cin >> i;
		cout << endl << "Product # " << pr[i - 1].product_number;
		cout << endl << "Enetr the product name ";
		cin.ignore();
		getline(cin, pr[i - 1].product_name);
		cout << endl << "Enter the product price ";
		cin >> pr[i - 1].product_price;
		cout << endl << "Enter the product quantity ";
		cin >> pr[i - 1].product_quantity;
		cout << endl << "Enter the product discount ";
		cin >> pr[i - 1].product_discount;

		cout << "\n press y to continue or not (Y/N)" << endl;
		cout << "Option : ";
		cin >> choice;
	} while (choice == 'y' || choice == 'Y');
	cout << "\n\n press y for admin menu or n for main menu " << endl;
	cout << "Option : ";
	cin >> character;

	if (character == 'y' || character == 'Y')
	{
		system("cls");
		admin_menu();

	}
	else {
		system("cls");
		Menu();
	}



}

void create_product()
{

	cout << "\n\n\n\t\t\t-----------------------------  Create New Product  ----------------------------" << endl << endl << endl;


	char Choice;
	do {
		counter++;
		cout << endl << "Please enter the product number : ";
		cin >> pr[i].product_number;
		cin.ignore();
		cout << endl << " Please Enter the Name of Product : ";
		getline(cin, pr[i].product_name);
		cout << endl << " Please Enter the Price of Product : ";
		cin >> pr[i].product_price;
		cout << endl << "Please Enter the Quantity of Product : ";
		cin >> pr[i].product_quantity;
		cout << endl << "Please Enter the Discount (%) : ";
		cin >> pr[i].product_discount;
		cin.ignore();
		cin.clear();
		cout << "Press y if you want to continue(y/n)";
		i++;
		cin >> Choice;
	} while (Choice == 'Y' || Choice == 'y');
	cout << "\n\n Press Y for Admin Menu and N for Main Menu " << endl;
	cout << "Option : ";
	cin >> character;
	if (character == 'Y' || character == 'y')
	{
		system("cls");
		admin_menu();
	}
	else
	{
		system("cls");
		Menu();
	}
}
void admin_login() {

	string Login_Name;
	string Login_Password;
	cout << "only admin can log in" << endl;
	cout << "\n\n\n\t\t ___________________________________________" << endl;
	cin.ignore();
PP:
	cout << " \n\t\t\tEnter User Name To Login : ";

	getline(cin, Login_Name);




	if (Login_Name == Account.User_Name)
	{
	p:
		cout << " \n\t\t\tEnter Password to Login  :";
		getline(cin, Login_Password);
		if (Login_Password == Account.Password)
		{
			system("cls");
			admin_menu();

		}
		else
		{
			cout << "\n\n\t\t\t Wrong Password Please Try Again " << endl;
			goto p;
		}

	}

	cout << "\n\n\t\t\t Wrong user name try again " << endl;
	goto PP;




}
