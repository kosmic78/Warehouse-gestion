# Warehouse gestion
# About the application
It's an application made in Java with a GUI. For storing the data i've made a mother class named Product with an ID and then 3 classes derived from the Product: Juices, Snacks and Sweets. Every derived class has their attributes: name, quantity and a price. I created a linked list where I stored my products. You can view all the products, you can sort them into categories. You can add a product, delete a product and edit a product. For the graphical interface I used JavaFX. For the backend part, for storing my data I have created a MySQL database in phpmyadmin. The data is being loaded from the database, when you delete an item it gets deleted from the database and when you add an item it gets loaded into the database and when you edit an item it also updates on database.
My application has also a login / register system implemented.
# Login page
![Login](https://imgur.com/a/di4OtRF.png)
# Register page
![Register](https://imgur.com/a/ji0g4md.png)
# Viewing all the products
![View](https://i.imgur.com/KkSmDuE.png)
# Viewing only the snacks
![Snacks](https://i.imgur.com/qj0Q3s5.png)
# Adding a product to the listview
![Add](https://i.imgur.com/e2jq8S3.png)

After pressing the 'Adauga suc' button, the item will be displayed in the listview:
![Added](https://i.imgur.com/lGVWBXz.png)
# Delete a product
After selecting a product and pressing the 'Sterge produs' button, an product will be deleted. I deleted all the juices:
![Delete](https://i.imgur.com/xISBsbX.png)
# Editing product with ID 1
![Edit](https://imgur.com/a/dSSdtSi.png)

After pressing the 'OK' button, on the next run of the application, the product with ID 1 will get updated:
![Edit](https://imgur.com/a/LJBcU3b.png)
