package com.example.krasimir.recipeturnik;

import android.app.Application;
import android.content.ContextWrapper;
import android.util.Log;

import com.example.krasimir.recipeturnik.model.Category;
import com.example.krasimir.recipeturnik.model.CategoryItems;
import com.example.krasimir.recipeturnik.model.Recipe;
import com.example.krasimir.recipeturnik.model.Users;
import com.orm.SugarContext;
import com.orm.SugarDb;

import java.io.File;


public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (doesDataBaseExist(this,"recipeturnik_database.db")){
            SugarDb sugarDb=new SugarDb(getApplicationContext());

            new File(sugarDb.getDB().getPath()).delete();
        }

        SugarContext.init(getApplicationContext());

        boolean doesDbExist=doesDataBaseExist(this,"recipeturnik_database.db");

        if (!doesDbExist){
            Category.findById(Category.class,(long)1);
            CategoryItems.findById(CategoryItems.class,(long)1);
            Recipe.findById(Recipe.class,(long)1);
            Users.findById(Users.class,(long)1);

            createDbCategory();

        }

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
    private  void createDbCategory(){
        Users admin=new Users("admin","admin@admin.bg","admin");
        Users pesho=new Users("pesho","pesho@abv.bg","123");
        pesho.save();
        admin.save();
        Category breakfastCategory= new Category("Breakfast","Healty,hot and full of flavor",R.mipmap.breakfast_img);
        Category lunchCategory= new Category("Lunch","Light meal and soups",R.mipmap.lunch_img);
        Category saladCategory= new Category("Salad","The most joyous healthy salad recipes",R.mipmap.salad_img);
        Category dinnerCategory= new Category("Dinner","The chief meal of the day",R.mipmap.dinner_img);
        Category dessertCategory= new Category("Desserts","Sweet, savory, decadent or healthy",R.mipmap.dessert_img);

        breakfastCategory.save();
        lunchCategory.save();
        saladCategory.save();
        dinnerCategory.save();
        dessertCategory.save();

        //breakfast
        CategoryItems theBigEggBreakfast=new CategoryItems(breakfastCategory, "The big egg","Three eggs cooked-to-order...",
                "https://www.bobevansgrocery.com/-/media/bobevans_com/images/our-recipes-and-grocery/recipes/recipe_detail_sausagepotatoesbreakfasttacos.jpg?h=744&la=en&w=1242&hash=A2BD26AF073D43C1465E37DE92130336C2A6C2DA");
        theBigEggBreakfast.save();

        Recipe theBigEggBreakfastRecipe=new Recipe(theBigEggBreakfast,"1 can black beans (15 oz), drained and rinsed,1 cup prepared salsa","25","6","In large non-stick skillet over medium heat, crumble and cook sausage until browned.Stir in black beans and salsa. Cook 1 to 2 minutes or until hot.Pour into bowl and keep warm. Wipe out skillet.");
        theBigEggBreakfastRecipe.save();



        CategoryItems sausageandSpinachOmelet = new CategoryItems(breakfastCategory, "Sausage and Spinach Omelet", "Spinach Omlet...",
                "https://www.bobevansgrocery.com/-/media/bobevans_com/images/our-recipes-and-grocery/recipes/recipedetail_sausagespinachomelet.jpg?h=744&la=en&w=1242&hash=A12D323E5BA8A47B76DCBC084F8BBB80B89500B1");
        sausageandSpinachOmelet.save();

        Recipe sausageandSpinachOmeletRecipe = new Recipe(sausageandSpinachOmelet, "3 cups chopped fresh spinach,1 can (15 oz.) white beans, rinsed and drained,12, eggs,3/4, cup shredded Fontina cheese,2, tablespoon minced thyme", "25", "6", "In medium skillet over medium heat crumble and cook sausage until browned.Stir in spinach and beans.Set aside,Heat small nonstick skillet over medium-high head,Whisk together 2 eggs. Add to pan,As eggs cook, push to center of pan. tilting pan to allow uncooked eggs to go toward the edge,When all egg is just set, top with 1/6 of sausage mixture and 2 Tbsp. of cheese,Fold omelet in half and slide onto plate. Sprinkle with 1 tsp. thyme. Repeat with remaining eggs to make 6 omelets.");
        sausageandSpinachOmeletRecipe.save();

        CategoryItems sausageBreakfastCasserole = new CategoryItems(breakfastCategory, "Sausage Breakfast Casserole", "Casserole",
                "https://www.bobevansgrocery.com/-/media/bobevans_com/images/our-recipes-and-grocery/recipes/recipedetail_sausagebreakfastcasserole.jpg?h=744&la=en&w=1242&hash=5DEF4C5A9E54C03A081305CD542D0A15AD6989F0");
        sausageBreakfastCasserole.save();

        Recipe sausageBreakfastCasseroleRecipe = new Recipe(sausageBreakfastCasserole, "2 cups shredded mozzarella cheese, 1 can refrigerated crescent dinner rolls (8 oz), 4 large eggs, beaten 3/4 cup milk ,1/4 teaspoon salt ,1/8 teaspoon black pepper", "30", "8", "Preheat oven to 425F.Crumble and cook sausage in skillet over medium heat until browned. Drain sausage.Line bottom of greased 13 x 9 inch baking dish with crescent roll dough, firmly pressing perforations to seal. Sprinkle with sausage and cheese.Combine remaining ingredients in medium bowl until blended, pour over sausage.Bake 15 minutes or until set. Let stand 5 minutes before cutting into squares; serve hot. Refrigerate leftovers.");
        sausageBreakfastCasseroleRecipe.save();

        //Lunch

        CategoryItems quickandEasyPizza = new CategoryItems(lunchCategory, "Quick and Easy Pizza", "Pizza",
                "https://www.bobevansgrocery.com/-/media/bobevans_com/images/our-recipes-and-grocery/recipes/recipedetail_bakedpotatopizza.jpg?h=744&la=en&w=1242&hash=C7451F29A7916E771646B801AA857FF906BCB5CA");
        quickandEasyPizza.save();

        Recipe quickandEasyPizzaRecipe = new Recipe(quickandEasyPizza, "1 prepared pizza crust (12-inch),1 can tomato sauce (8 oz),1/4 teaspoon crushed dried basil leaves,1 pkg. shredded mozzarella cheese (8 oz) ,1/4 teaspoon crushed dried oregano.", "25", "4", "Preheat oven to 450F.In a large skillet, cook and crumble sausage until brown. Remove from heat and drain.Place pizza crust on a large baking sheet.Combine tomato sauce, basil, and oregano. Spread tomato sauce evenly over pizza.Sprinkle sausage evenly over tomato sauce and top with Mozzarella cheese.Bake 10-12 minutes or until cheese is melted and lightly golden.Cut into wedges and serve.");
        quickandEasyPizzaRecipe.save();


        CategoryItems veggieMacaroniandCheese = new CategoryItems(lunchCategory, "Veggie Macaroni and Cheese", "Macaroni",
                "https://www.bobevansgrocery.com/-/media/bobevans_com/images/our-recipes-and-grocery/recipes/recipedetail_veggiemacaronicheese.jpg?h=744&la=en&w=1242&hash=535A5B5D89496161C2645A9196B7DA8A3A111E10");
        veggieMacaroniandCheese.save();

        Recipe veggieMacaroniCheeseRecipe = new Recipe(veggieMacaroniandCheese, "1 zucchini diced,1cup halved cherry tomatoes, 1 cup chopped fresh spinach", "35", "5", "Preheat oven to 350F,In large skillet over medium heat, add zucchini and stir in macaroni and cheese, tomatoes and spinach. Pour into 2 qt. baking dish,Bake 20 to 25 minutes or until hot");
        veggieMacaroniCheeseRecipe.save();

        CategoryItems southwestSausageBurger = new CategoryItems(lunchCategory, "Southwest Sausage Burger", "Burger",
                "https://www.bobevansgrocery.com/-/media/bobevans_com/images/our-recipes-and-grocery/recipes/recipedetail_southwestburgers.jpg?h=744&la=en&w=1242&hash=EA6EE3F07AA6EFA5D6CD56A899933CB59C53CE1D");
        southwestSausageBurger.save();

        Recipe southwestSausageBurgerRecipe = new Recipe(southwestSausageBurger, "2 tablespoons cilantro, chopped,2 tablespoons diced red onions,1/2 cup mild or medium salsa,1/2 teaspoon chili powder,1/2 teaspoon ground cumin,Black pepper to taste,4 slices smoked Cheddar or favorite cheese,4 kaiser or hard rolls", "10", "4", " On a clean cutting board, wash and chop cilantro and onions separately. In a large bowl combine sausage, salsa, onions, cilantro and seasonings. Form into 4 tor 5 patties, depending on size desired,Over medium heat on grill, cook burgers on each side until done (no longer pink in the center), about 10-15 minutes* (depending on size).,If desired, melt cheese over top before serving. Serve with rolls, salsa or favorite condiments and tortilla chips.,Refrigerate leftovers. Can prepare in oven or pan fry on stove top. ");
        southwestSausageBurgerRecipe.save();

        //Salad

        CategoryItems walkingTacoSalad = new CategoryItems(saladCategory, "Walking Taco Salad", "Salad",
                "https://www.bobevansgrocery.com/-/media/bobevans_com/images/our-recipes-and-grocery/recipes/recipes-2nd-release/recipedetail_walkingtacosalad.jpg?h=744&la=en&w=1242&hash=777FE0DF984E6C80DF87AA6279FCF8C0DDCA29C1");
        walkingTacoSalad.save();

        Recipe walkingTacoSaladRecipe = new Recipe(walkingTacoSalad, "1 pkg. taco seasoning mix (1 ounce), 1 head Iceberg lettuce, shredded, 4 packages corn chips (2.5 oz. bags), 1 cup Cheddar cheese, shredded, 1 pkg. pico de gallo (10 oz. prepared), 12 oz. cilantro lime crema (see recipe below), 4 tablespoons Cilantro, roughly chopped, Cilantro Lime Crema Ingredients: 12 oz. sour cream, 1/4 teaspoon salt, 1/4 cup fresh lime juice, 1/3 cup cilantro, finely chopped", "30", "5", "Place all ingredients for crema in a mixing bowl and stir until fully combined,Place into a squeeze bottle or salad dressing container and refrigerate for at least 15 minutes to allow the flavors to combine. Keep up to 6 days ,Cook the sausage in a medium sized frying pan over medium heat using a potato masher to break into crumbles. Drain any excess oil.Mix in the taco seasoning and stir until fully incorporated. Place a lid or foil over skillet to keep sausage warm. Place shredded lettuce divided equally onto 4 individual plates.Cut the corners off of the bags of corn chips and a slit open down the middle and place on top of lettuce,Equally divide and spoon the sausage mixture, cheddar cheese, pico de gallo over corn chips and lettuce.Drizzle the walking taco mixture and the shredded lettuce with cilantro lime crema and garnish with cilantro.");
        walkingTacoSaladRecipe.save();

        //Dinner

        CategoryItems easyItalianSausageLasagna = new CategoryItems(dinnerCategory, "Easy Italian Sausage Lasagna", "Lasagna",
                "https://www.bobevansgrocery.com/-/media/bobevans_com/images/our-recipes-and-grocery/recipes/recipedetail_easyitaliansausagelasagna.jpg?h=744&la=en&w=1242&hash=EC806E5FC5B9B199F025E4A79DB7D4E3C801E72E");
        easyItalianSausageLasagna.save();

        Recipe easyItalianSausageLasagnaRecipe = new Recipe(easyItalianSausageLasagna, "1 jar pasta sauce (26 oz), 1 can tomato sauce (15 oz), 1 pkg. oven ready lasagna noodles (8 oz), 1 container ricotta cheese (15 oz), 1 teaspoon Italian seasoning, 4 cups shredded mozzarella cheese, 1/2 cup grated Parmesan cheese,", "70", "8", "In a skillet, crumble and cook sausage over medium heat until brown. Remove from heat and stir in pasta sauce and tomato sauce,In small bowl, combine ricotta cheese and Italian seasoning.Preheat oven to 375F.Spread 1 cup sauce into bottom of a 9 x 13 inch baking dish. Top with 3 noodles. Cover noodles with 1/3 of ricotta cheese mixture, 1 cup of mozzarella and 1 cup sauce. Repeat layers two more times.Add last 3 noodles. Top lasagna with remaining sauce and with remaining mozzarella cheese. Sprinkle Parmesan over mozzarella.Cover and bake 45 to 50 minutes or until noodles are tender. Uncover and bake an additional 5 minutes to melt cheese.");
        easyItalianSausageLasagnaRecipe.save();

        CategoryItems italianPastaFlorentine = new CategoryItems(dinnerCategory, "Italian Pasta Florentine", "Pasta",
                "https://www.bobevansgrocery.com/-/media/bobevans_com/images/our-recipes-and-grocery/recipes/recipedetail_italianpastaflorentine.jpg?h=744&la=en&w=1242&hash=87EC48FA37FE2D8444A77B0BAF7A38D54B4E68D5");
        italianPastaFlorentine.save();

        Recipe italianPastaFlorentineRecipe = new Recipe(italianPastaFlorentine, "2 tablespoons olive oil, 2-3 cloves garlic, minced, 4 quarts water, 5 pkg. wide egg noodles (8 oz), 2 cups frozen chopped spinach, 1/3 cup grated Romano cheese, Salt & black pepper to taste", "35", "5", "In a large skillet over medium-low heat, add 2 tablespoons of olive oil. Add garlic and cook until lightly golden brown.Add crumbled sausage and continue to cook until brown. Drain sausage. Place mixture to side, keeping warm in oven on low heat setting.In a large pot, bring 4 quarts of water to a boil. Add noodles and cook according to package directions.Add frozen spinach during last 2-3 minutes of cooking time. Drain noodles and spinach.Add spinach and noodles to large serving bowl, combine cooked sausage and gently toss. Top with Romano cheese. Serve immediately. Refrigerate leftovers,");
        italianPastaFlorentineRecipe.save();

        CategoryItems bbqSweetandSpicyChili = new CategoryItems(dinnerCategory, "BBQ Sweet and Spicy Chili", "BBQ",
                "https://www.bobevansgrocery.com/-/media/bobevans_com/images/our-recipes-and-grocery/recipes/recipedetail_bbqsweetspicychili.jpg?h=744&la=en&w=1242&hash=A76CA5B36C2C58252249BF22C032832F58441D48");
        bbqSweetandSpicyChili.save();

        Recipe bbqSweetandSpicyChiliRecipe = new Recipe(bbqSweetandSpicyChili, "3/4 cup sweet BBQ sauce, 1 can (16 oz.) chili beans, 1 can (14 oz.) diced tomatoes, 1 can (4.25 oz) chopped green chilies, 1 cup frozen corn, red and green pepper and onion blend, 1 teaspoon ground cumin, Optional toppings: sour cream, shredded cheddar cheese, corn chips", "30", "6", "In large saucepan over medium heat, crumble and cook sausage until brown.Stir in BBQ sauce, beans, tomatoes, green chilies, corn blend and cumin. Bring to a boil. Reduce heat to low and simmer for 15 minutes.Serve with any desired toppings.");
        bbqSweetandSpicyChiliRecipe.save();

        //Dessert
        CategoryItems sweetPotatoPie=new CategoryItems(dessertCategory,"Sweet Potato Pie","Pie",
                "https://www.bobevansgrocery.com/-/media/bobevans_com/images/our-recipes-and-grocery/recipes/recipes-2nd-release/recipedetail_sweetpotatopie.jpg?h=744&la=en&w=1242&hash=3657AC63D119E0E2A00C91CAE36A3EA113D06A20");
        sweetPotatoPie.save();

        Recipe sweetPotatoPieRecipe= new Recipe(sweetPotatoPie,"1 can Sweetened Condensed Milk ,1 1/2 teaspoons Pumpkin Pie Spice, 2 eggs, beaten, 1 -9 Frozen Pie Crust","60","6","Preheat oven to 400 F. Using a fork, prick the bottom of the pie crust.In a large mixing bowl, mix together Bob Evans Mashed Sweet Potatoes, sweetened condensed milk, pumpkin pie spice and eggs. Mix until well incorporated. Carefully pour into pie shell.Bake for 45 -65 minutes or until middle of pie is firm. Carefully remove from oven and allow to cool before serving. *Pie will be puffy when it comes out of oven and will sink as it cools. ");
        sweetPotatoPieRecipe.save();

        CategoryItems appleCherryFreeFormPie=new CategoryItems(dessertCategory,"Apple Cherry Free Form Pie","Pie",
                "https://www.bobevansgrocery.com/-/media/bobevans_com/images/our-recipes-and-grocery/recipes/recipedetail_applecherryfreeformpie.jpg?h=744&la=en&w=1242&hash=A78B91EEB1872A79FB1BDE029DFD565CC687A4A2");
        appleCherryFreeFormPie.save();

        Recipe appleCherryFreeFormPieRecipe=new Recipe (appleCherryFreeFormPie,"1 refrigerated piecrust for 9\" pie (1/2 of 15 oz. package), 1/2 cup chopped dried cherries, Milk (optional), Cinnamon and sugar (optional), 1 teaspoon butter","30","6","Preheat oven to 400F.Place pie crust onto large rimmed baking sheet.Fold the edge of the pie crust over the apple filling, pleating the crust and pressing down the edge to hold in place (the crust will not cover all of the filling).Dot the filling with small pieces of butter. Brush the crust with milk and sprinkle with cinnamon and sugar, if desired.Bake pie for 30 to 35 minutes or until crust is golden brown. ");
        appleCherryFreeFormPieRecipe.save();

    }
    private boolean doesDataBaseExist(ContextWrapper context,String dbName){

        File dbFile=context.getDatabasePath(dbName);

        return dbFile.exists();

    }
}
