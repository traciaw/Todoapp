//Doing a Product web app, in product page to 
//display the name, description, imageUrl, style, price, ..., ...,.....,....


const createHTMLList = (index, header, description, due) =>
`
                        <div class="col">
                        <div class="card bg-warning" style="width: 18rem;">
                          <div class="card-body">
                            <h5 class="card-title">${header}</h5>
                            <h6 class="card-subtitle mb-2" style="color:purple">${due}</h6>
                            <p class="card-text">${description}</p>

                          </div>
                        </div>
                        </div>

`;

function displayToDoDetails(item)
{
    document.querySelector("#modalHeader").innerText = item.header;
    document.querySelector("#modalDescription").src = item.description;
    document.querySelector("#modalDue").innerText = item.due;

}

class ProductsController 
{
    constructor()
    {
        this._items = [];       //create an array to store the details of product items
    }

    //method to add the items into the array
    addItem(header, description, due)
        {
            //fetch POST HTTP method to send the data to the backend via the API
            var productController = this;
            const formData = new FormData();
            formData.append('header', header);
            formData.append('description', description);
            formData.append('due', due);
            //formData.append('imagefile',imageObject);

           fetch('http://localhost:8080/item/add', {
                 method: 'POST',
                 body: formData
                 })
                 .then(function(response) {
                     console.log(response.status); // Will show you the status
                     if (response.ok) {
                         alert("Successfully Added!")
                     }
                 })
                 .catch((error) => {
                     console.error('Error:', error);
                     alert("Error adding item")
                 });
        }


    displayItem()
    {
        //fetch the item from the database using the API
         var productController = this;
         productController._items = [];

          //fetch data from database using the REST API endpoint from Spring Boot
                 fetch('http://127.0.0.1:8080/item/all')
                     .then((resp) => resp.json())
                     .then(function(data) {
                         console.log("2. receive data")
                         console.log(data);
                         data.forEach(function (item, index) {

                             const itemObj = {
                                 id: item.id,
                                 header: item.header,
                                 description: item.description,
                                 due: item.due,
                            };
                             productController._items.push(itemObj);
                       });

                       productController.renderProductPage();

                     })
                     .catch(function(error) {
                         console.log(error);
                     });

    }

    renderProductPage()
    {
        var productHTMLList = [];
        
        for (var i=0; i<this._items.length; i++)
        {
            const item = this._items[i];            //assign the individual item to the variable

            const productHTML = createHTMLList(i, item.header, item.description, item.due);

            productHTMLList.push(productHTML);
        }

        //Join all the elements/items in my productHTMLList array into one string, and seperate by a break
        const pHTML = productHTMLList.join('\n');
        document.querySelector('#row').innerHTML = pHTML;


        //addEventListener - click 
        for (var i=0; i<this._items.length; i++)
        {
            const item = this._items[i];
            document.getElementById(i).addEventListener("click", function() { displayToDoDetails
            (item);} );
        }


    }


}   //End of ProductsController class
