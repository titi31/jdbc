import java.util.ArrayList;

public class Article {

	private int IdArticle;
	private String Description;
	private String Brand;
	private int UnitaryPrice;

	public Article(int IdArticle, String Description, String Brand, int UnitaryPrice) {
		this.IdArticle = IdArticle;
		this.Description = Description;
		this.Brand = Brand;
		this.UnitaryPrice = UnitaryPrice;
	}
	public Article(int IdArticle, String Description, String Brand) {
		this.IdArticle = IdArticle;
		this.Description = Description;
		this.Brand = Brand;
		this.UnitaryPrice = 0;
	}
	public int getIdArticle() {
		return IdArticle;
	}

	public void setIdArticle(int idArticle) {
		IdArticle = idArticle;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public int getUnitaryPrice() {
		return UnitaryPrice;
	}

	public void setUnitaryPrice(int unitaryPrice) {
		UnitaryPrice = unitaryPrice;
	}

	@Override
	public String toString() {
		return "Article [IdArticle=" + IdArticle + ", Description=" + Description + ", Brand=" + Brand
				+ ", UnitaryPrice=" + UnitaryPrice + "]";
	}
}
