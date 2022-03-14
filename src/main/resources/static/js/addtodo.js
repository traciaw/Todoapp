const productsControl = new ProductsController();


//When user clicks on 'Save Item', calls API to add items to the database
//Add an 'onsubmit' event listener for productform to add a product
newItemForm.addEventListener('submit', (event) => {
    // Prevent default action
    event.preventDefault();
    // Select the inputs
    const headerInput = document.querySelector('#headerInput');
    const descriptionInput = document.querySelector('#descriptionInput');
    const dueInput = document.querySelector('#dueInput');


    // Get the values of the inputs - variable names to be same as MySQL columns
    const header = headerInput.value;
    const description = descriptionInput.value;
    const due = dueInput.value;


  // Clear the form
    headerInput.value = '';
    descriptionInput.value = '';
    dueInput.value = '';

    // Add the task to the task manager
    productsControl.addItem(header, description, due, storeImage);

});
//Get the image object
// select file input
const input = document.querySelector('#newItemImageFile');

// add event listener
input.addEventListener('change', () => {
    storeImage = input.files[0];
});
