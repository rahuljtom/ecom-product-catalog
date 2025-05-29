import { useState } from "react";
import { useEffect } from "react";
import "./App.css";
import ProductList from "./Productlist";
import CategoryFilter from "./CategoryFilter";

function App() {
  const [Products, setProducts] = useState([]);
  const [Categories, setCategories] = useState([]);
  const [selectedCategories, setselectedCategories] = useState(null);

  const [SearchTerm, setSearchTerm] = useState("");
  const [SearchOrder, setSearchOrder] = useState("asc");
  const handleSearchChange = (event) => {
    setSearchTerm(event.target.value);
  };

  const handleSortOrder = (event) => {
    setSearchOrder(event.target.value);
  };

  const handleCategorySelect = (categoryId) => {
    setselectedCategories(categoryId === "" ? null : Number(categoryId));
  };

  useEffect(() => {
    fetch("http://localhost:8080/api/products")
      .then((res) => res.json())
      .then((data) => {
        console.log("Fetched products:", data);
        setProducts(data);
      })
      .catch((err) => console.error("Error fetching products:", err));

    fetch("http://localhost:8080/api/categories")
      .then((res) => res.json())
      .then((data) => {
        console.log("Fetched categories:", data);
        setCategories(data);
      })
      .catch((err) => console.error("Error fetching categories:", err));
  }, []);

  console.log("selectedCategories:", selectedCategories);
  console.log("Products:", Products);

  const FilteredProducts = Products.filter((product) =>
    selectedCategories ? product.category.id === selectedCategories : true
  )
    .filter((product) =>
      product.name.toLowerCase().includes(SearchTerm.toLowerCase())
    )
    .sort((a, b) =>
      SearchOrder === "asc" ? a.price - b.price : b.price - a.price
    );

  return (
    <div className="container">
      <h1 className="my-4">Product Catalog</h1>

      <div className="row align-items-center mb-4">
        <div className="col-md-3 col-sm-12 mb-2">
          <CategoryFilter
            categories={Categories}
            onSelect={handleCategorySelect}
          />
        </div>
        <div className="col-md-5 col-sm-12 mb-2">
          <input
            type="text"
            className="form-control"
            placeholder="Search for products"
            value={SearchTerm}
            onChange={handleSearchChange}
          ></input>
          <div>
            <select className="form-control" onChange={handleSortOrder}>
              <option value="asc"> Sort by price: Low to High</option>
              <option value="desc"> Sort by price: High to Low</option>
            </select>
          </div>
        </div>
      </div>
      {FilteredProducts.length ? (
        <ProductList products={FilteredProducts} />
      ) : (
        <p>No products found</p>
      )}
    </div>
  );
}

export default App;


//BE implementation of search feature bc FE becomes too resource heavy

// query parameter
// search parameters
//request body 