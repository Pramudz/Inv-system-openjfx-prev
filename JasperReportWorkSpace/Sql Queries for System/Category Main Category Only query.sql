select main.cat_name as maincat, cat.cat_name as subcat from category cat right join category main on main.cat_id=cat.main_category where main.category_type="main" group by main.cat_name;