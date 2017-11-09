using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_17B
{
    class DataArray
    {
        private Person[] arr;
        public static void Main(String[] args)
        {
            //Create array
            DataArray x = new DataArray(10);

            //Populate array
            x.InsertPerson("Evans", "Patty", 24);
            x.InsertPerson("Smith", "Lorraine", 37);
            x.InsertPerson("Yee", "Tom", 43);
            x.InsertPerson("Adams", "Henry", 63);
            x.InsertPerson("Hashimoto", "Sato", 21);
            x.InsertPerson("Stimson", "Henry", 29);
            x.InsertPerson("Velasquez", "Jose", 72);
            x.InsertPerson("Lamarque", "Henry", 54);
            x.InsertPerson("Vang", "Minh", 22);
            x.InsertPerson("Creswell", "Lucinda", 18);

            //Display all Persons
            x.DisplayAllPersons();

            //Try find
            TryToFind(x, "Stimson");

            //Try bad find
            TryToFind(x, "Jacobson");

            //Try delete
            tryToDelete(x, "Smith");
            tryToDelete(x, "Yee");
            //Try bad delete
            tryToDelete(x, "Thompson");

            //Display all Persons
            x.DisplayAllPersons();

            //Get users input and try to create
            tryToCreate(x);

            //Display all persons
            x.DisplayAllPersons();

            Console.ReadLine();
        }

        public DataArray(int maxSize)
        {
            this.arr = new Person[maxSize];
        }

        //Try to find person. Null if not found and Person if found
        Person Find(String searchName)
        {
            foreach (Person p in arr)
            {
                if (p.LastName == searchName)
                {
                    return p;
                };
            }
            return null;
        }

        //Add person. Expand array if last value set and set last if null
        public void InsertPerson(String last, String first, int age)
        {
            if (arr[arr.Length - 1] == null)
            {
                for (int i = 0; i < arr.Length; i++)
                {
                    if (arr[i] == null)
                    {
                        arr[i] = new Person(last, first, age);
                        break;
                    }
                }
            }
            else
            {
                int i = arr.Length;
                Person[] newArr = new Person[arr.Length + 1];
                Array.Copy(arr, newArr, i);
                arr = newArr;
                InsertPerson(last, first, age);
            }
        }

        //Test if person exists and then delete if true
        public bool DeletePerson(String searchName)
        {
            if (Find(searchName) == null)
            {
                return false;
            }
            else
            {
                for (int i = 0; i < arr.Length; i++)
                {
                    if (arr[i].LastName == searchName)
                    {
                        int og = arr.Length;
                        arr[i] = arr[og - 1];
                        Array.Copy(arr, arr, og - 1);
                        break;
                    }
                }


                return true;
            }
        }

        //Loop through all persons and display them
        public void DisplayAllPersons()
        {
            int i = 1;
            foreach (Person p in arr)
            {
                if (p == null) break;
                Console.Write(i + ")");
                p.DisplayPerson();
                i++;
            }
            Console.WriteLine();
        }
        //Call DataArray method and test find
        static Person TryToFind(DataArray x, String sn)
        {
            Person p = x.Find(sn);
            if (p == null)
            {
                Console.WriteLine("Can't find '" + sn + "'\n");
            }
            else
            {
                Console.WriteLine("Found \t");
                p.DisplayPerson();
                Console.WriteLine();
                return p;
            }
            return null;
        }
        // Call DataArray method and test delete
        public static void tryToDelete(DataArray x, String sn)
        {
            if (x.DeletePerson(sn))
            {
                Console.WriteLine("Successfully deleted '" + sn + "'");
            }
            else
            {
                Console.WriteLine("Not found. Could not delete '" + sn + "'\n");
            }

        }

        // Call DataArray method and test create
        // Call DataArray method and test create
        public static void tryToCreate(DataArray x)
        {
            String f, l;
            int a;
            Console.WriteLine("Insert: Please enter the first name: ");
            f = Console.ReadLine();
            Console.WriteLine("Insert: Please enter the first name: ");
            l = Console.ReadLine();
            Console.WriteLine("Insert: Please enter the age: ");
            a = Convert.ToInt32(Console.ReadLine());

            x.InsertPerson(l, f, a);
            Console.WriteLine("Person %s %s %d entered sucessfully \n\n", f, l, a);


        }
        class Person
        {
            public String LastName;
            public String FirstName;
            public int Age;

            public Person(String last, String first, int Age)
            {
                this.LastName = last;
                this.FirstName = first;
                this.Age = Age;
            }

            public Person()
            {
                new Person(String.Empty, String.Empty, 0);
            }

            public void DisplayPerson()
            {
                Console.WriteLine("{0,12} {1,-12} Age: {2}", FirstName, LastName, Age);
            }



        }
    }
}
