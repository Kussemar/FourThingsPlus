package dat.backend.model.entities;

public class Category
{
    // Attributter
    private String categoryName;


    // Constructors

    public Category(String categoryName)
    {
        this.categoryName = categoryName;
    }

    // Gettere og måske settere

    public String getCategoryName()
    {
        return categoryName;
    }

    public void setCategoryName(String categoryName)
    {
        if (categoryName.length() > 0)
        {
            this.categoryName = categoryName;
        }
    }

    //



    // Andet godt  toString etc og egne metoder
}
