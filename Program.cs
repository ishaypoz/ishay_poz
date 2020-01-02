using System;
using System.Net;
using System.Web;

namespace api
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Please Choose (1,2,3,4) \n 1. /Search \n 2. /Search with more than 1 key \n 3. Get Albums 1 and more \n 4. Get Artist 1 and more \n");
            string caseKey = Console.ReadLine();
            switch (caseKey)
            {
                case "1":
                    Console.WriteLine("iTunes Search: ");
                    string searchKey = Console.ReadLine();
                    string quary = HttpUtility.UrlEncode(searchKey);
                    using (WebClient wc = new WebClient())
                    {
                        try{
                            var json = wc.DownloadString("https://itunes.apple.com/search?term="+quary);
                            Console.WriteLine(json);
                        }
                        catch (Exception ex)
                        {
                        }
                    }
                    break;
 
                case "2":
                    Console.WriteLine("iTunes Search: ");
                    string searchKeyLimited = Console.ReadLine();
                    Console.WriteLine("Limit result to: ");
                    string limitKey = Console.ReadLine();
                    string quaryLimited = HttpUtility.UrlEncode(searchKeyLimited);
                    using (WebClient wc = new WebClient())
                    {
                        try{
                            var json = wc.DownloadString("https://itunes.apple.com/search?term="+quaryLimited+"&limit="+limitKey);
                            Console.WriteLine(json);
                        }
                        catch (Exception ex)
                        {
                        }
                    }
                    break;
            
                case "3":
                    Console.WriteLine("iTunes Albums Search: ");
                    string albumsKey = Console.ReadLine();
                    string albumsQuary = HttpUtility.UrlEncode(albumsKey);
                    using (WebClient wc = new WebClient())
                    {
                        try{
                            var json = wc.DownloadString("https://itunes.apple.com/search?term="+albumsQuary+"&entity=album");
                            Console.WriteLine(json);
                        }
                        catch (Exception ex)
                        {
                        }
                    }
                    break;
            
                case "4":
                    Console.WriteLine("iTunes Artists Search: ");
                    string artistsKey = Console.ReadLine();
                    string artistsQuary = HttpUtility.UrlEncode(artistsKey);
                    using (WebClient wc = new WebClient())
                    {
                        try{
                            var json = wc.DownloadString("https://itunes.apple.com/search?term="+artistsQuary+"&entity=musicArtist");
                            Console.WriteLine(json);  
                        }
                        catch (Exception ex)
                        {
                        }
                    }
                    break;
            
                default:

                    break;
            }
        }
    }
}
