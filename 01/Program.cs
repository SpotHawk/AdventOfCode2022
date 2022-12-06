namespace aoc22_01
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string[] sorok = File.ReadAllLines(Console.ReadLine());
            int sum = 0, max = 0, max2 = 0, max3 = 0, sum3 = 0;

            foreach (var item in sorok)
            {
                if (item!="")
                {
                    sum+= int.Parse(item);
                    sum3 = max + max2 + max3;
                }
                else
                {
                    if (sum > max)
                    {
                        max3 = max2;
                        max2 = max;
                        max = sum;
                    }
                    else if (sum > max3)
                    {
                        max3 = max2;
                        max2 = sum;
                    }
                    sum = 0;
                    sum3 = 0;
                }
            }

            Console.WriteLine($"Max: {max}, Top 3 sum: {sum3}");
        }
    }
}