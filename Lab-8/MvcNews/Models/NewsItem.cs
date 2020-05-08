using System;
using System.ComponentModel.DataAnnotations;

namespace MvcNews.Models
{
    public class NewsItem
    {
        [Required]
        [StringLength(140, MinimumLength = 5)]
        public string Text { get; set; }

        public int id { get; set; }

        [DataType(DataType.Date)]
        public DateTime TimeStamp { get; set;}

        [Timestamp]
        public byte[] RowVersion { get; set; }
    }
}