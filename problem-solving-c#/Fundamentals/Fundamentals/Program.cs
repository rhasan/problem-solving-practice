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
            IStack<string> rStack = new ResizingStack<string>();
            string[] words = Console.In.ReadLine().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
            pushPopPrint(rStack, words);

            IStack<string> lStack = new LinkedStack<string>();
            pushPopPrint(lStack, words);
        }

        private static void pushPopPrint(IStack<string> stack, string[] words)
        {
            foreach (string word in words)
            {
                if (!stack.isEmpty() && word == "-")
                {
                    Console.Write(stack.pop());
                    Console.Write(" ");
                }
                else
                {
                    stack.push(word);
                }
            }
            Console.WriteLine("");
        }
    }
}
