package app.service;

import app.model.Product;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ProductServiceImpl implements IProductService {
	private static Map<Long, Product> products;
	private static Long id = 3L;

	static {
		products = new HashMap<>();
		Product product = new Product(1L,"Áo thun", 90000, 3, "Áo thun thoáng mát, Mát vào mùa hè, lóng vào mùa đông", "CodeGym");
		Product product2 = new Product(2L,"Quần jean", 160000, 2, "Quần jean đẹp, style trẻ trung...", "CodeGym");

		products.put(1L, product);
		products.put(2L, product2);
	}

	public ProductServiceImpl(){
	}

	@Override
	public List<Product> findAll() {
		List<Product> list = new ArrayList<>(products.values());
		return list;
	}

	@Override
	public Product findById(Long id) {
		return products.get(id);
	}

	@Override
	public void save(Product product) {
		if (product.getId() == null || product.getId() == 0L){
			Long newId = id++;
			product.setId(newId);
			products.put(newId, product);
		}else{
			products.put(product.getId(), product);
		}
	}

	@Override
	public void delete(Long id) {
		products.remove(id);
	}
}
