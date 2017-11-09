using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_18B
{
    public class Person : IComparable<Person> {


        public String LastName;
        public String FirstName;
        public int Age;

        public Person(String last, String first, int a)
        {
            LastName = last;
            FirstName = first;
            Age = a;
        }

        public Person()
        {
            new Person("", "", 0);
        }

        public void displayPerson()
        {
            Console.WriteLine("{0,12} {1,-12} Age: {2,2}", LastName, FirstName, Age);
        }

        public int CompareTo(Person other)
        {
            if (this.LastName.Equals(other))
            {
                if (this.FirstName.Equals(other))
                {
                    return (this.Age).CompareTo(other.Age);
                }
                else
                {
                    return this.FirstName.CompareTo(other.FirstName);
                }
            }
            return this.LastName.CompareTo(other.LastName);
        }

        public Boolean Equals(Object obj)
        {
            if (this == obj) return true;
            if (obj == null || this.GetType() != obj.GetType()) return false;

            Person other = (Person)obj;

            if (this.GetType() == other.GetType()) return true;

            if (this.Age != other.Age)
            {
                return false;
            }

            if (this.FirstName == null && other.FirstName != null)
            {
                return false;
            }
            else if (!this.FirstName.Equals(other.FirstName)) return false;

            if (this.LastName == null && other.LastName != null)
            {
                return false;
            }
            else if (!this.LastName.Equals(other.LastName)) return false;

            return false;
        }

        public override int GetHashCode()
        {
            const int prime = 31;
            int result = 1;
            result = result * prime + this.Age;
            result = result * prime + ((this.FirstName == null) ? 0 : this.FirstName.GetHashCode());
            result = result * prime + ((this.LastName == null) ? 0 : this.LastName.GetHashCode());
            return result;
        }

        public override String ToString()
        {
            return String.Format("{0,12} {,-12} Age: {2,2}", FirstName, LastName, Age);
        }

    }

    public class DataArray
    {
        public Person[] arr;

        public DataArray(int maxSize)
        {
            this.arr = new Person[maxSize];
        }

        public Person Find(String searchName)
        {
            foreach (Person p in arr)
            {
                if (p.LastName == (searchName))
                {
                    return p;
                };
            }
            return null;
        }

        public Person Find(Person otherPerson)
        {
            foreach (Person p in arr)
            {
                if (p.Equals(otherPerson)) return p;
            }
            return null;
        }

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
                Person[] newArr = new Person[i + 1];
                Array.Copy(arr, newArr, i);
                arr = newArr;
                InsertPerson(last, first, age);
            }
        }

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
                    if (arr[i].LastName == (searchName))
                    {
                        for(int ii = i; i < arr.Length; ii++)
                        {
                            if(ii++ >= arr.Length-1) break;
                            arr[i] = arr[ii];
                        }
                        
                        break;
                    }
                }


                return true;
            }
        }

        public void DisplayAllPersons()
        {
            int i = 1;
            foreach (Person p in arr)
            {
                if (p == null) break;
                Console.Write(i + ")");
                p.displayPerson();
                i++;
            }
            Console.WriteLine();
        }

        public void BubbleSort()
        {
            int inner, outer;
            Person t;
            for (outer = arr.Length - 1; outer > 0; outer--)
            {
                for (inner = 0; inner < outer; inner++)
                {
                    if (arr[inner].CompareTo(arr[inner + 1]) > 0)
                    {
                        t = arr[inner];
                        arr[inner] = arr[inner + 1];
                        arr[inner + 1] = t;
                    }
                }
            }
        }
    }

    public class home
    {
        public static void Main(String[] arr)
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
            tryToFind(x, "Stimson");

            //Try bad find
            tryToFind(x, "Jacobson");

            tryToDelete(x, "Smith");
            tryToDelete(x, "Yee");
            tryToDelete(x, "Thompson");

            x.DisplayAllPersons();

            tryToCreate(x);

            x.BubbleSort();

            x.DisplayAllPersons();
            Console.ReadKey();
        }

        public static Person tryToFind(DataArray x, String sn)
        {
            Person p = x.Find(sn);
            if (p == null)
            {
                Console.WriteLine("Can't find '" + sn + "'\n");
            }
            else
            {
                Console.WriteLine("Found \t");
                p.displayPerson();
                Console.WriteLine();
                return p;
            }
            return null;
        }

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
            Console.WriteLine("Person {0,12} {1,-12} Age: {2,2} created successfully. ", f, l, a);


        }


    }
}
