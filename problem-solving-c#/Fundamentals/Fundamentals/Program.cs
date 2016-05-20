using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Fundamentals
{
    class Program
    {
        static void Main(string[] args)
        {
            IStack<string> stack = new ResizingStack<string>();
            string[] words = Console.In.ReadLine().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
            foreach (string word in words) 
            {
                if (word == "-") 
                {
                    Console.Write(stack.pop());
                    Console.Write(" ");
                }
                else
                {
                    stack.push(word);
                }
                //Console.WriteLine(word);
            }
        }
    }
}
