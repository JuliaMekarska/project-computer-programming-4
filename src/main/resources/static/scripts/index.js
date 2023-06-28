const getProducts = () => {
    return fetch("/api/products")
        .then((response) => response.json())
        .catch((error) => console.log(error))
};

const getCurrentOffer = () => {
    return fetch("/api/current-offer")
        .then((response) => response.json())
}

const handleAddToCart = (productId) => {
    return fetch(`/api/cart/${productId}`, {
        method: 'POST'
    });
};

const refreshCurrentOffer = () => {
    console.log('i am going to refresh offer');
    const offerElement = document.querySelector('.cart');

    getCurrentOffer()
        .then(offer => {
            offerElement.querySelector('.total').textContent = `${offer.total} PLN`;
            offerElement.querySelector('.itemsCount').textContent = `${offer.productsCount} items`;
        });
}

const createHtmlElementFromString = (template) => {
    let tmpElement = document.createElement('div');
    tmpElement.innerHTML = template.trim();

    return tmpElement.firstChild;
}

const createProductComponent = (product) => {
    const template = `
        <li class="product">
            <span class="name">${product.name}</span>
            <div class="product__image-container">
                <img class="image" src="${product.image}" width="360"/>
            </div>
            <span class="price">${product.price}</span>
            <button class="product__add-to-cart"
                data-product-id="${product.id}"
            >
                Add to cart
            </button>
        </li>
    `;

    return createHtmlElementFromString(template);
}

const initializeAddToCartHandler = (el) => {
    el.addEventListener('click', (e) => {
        let button = e.target;
        const productId = button.getAttribute('data-product-id');

        handleAddToCart(productId)
            .then(() => refreshCurrentOffer())
            .catch((error) => console.log(error))
        ;
    });

    return el;
}

const initializeEcommerce = async () => {
    await refreshCurrentOffer();

    const productsList = document.querySelector('#productsList');
    const products = await getProducts();
    products
        .map(p => createProductComponent(p))
        .map(productEl => initializeAddToCartHandler(productEl))
        .forEach(productEl => {
            productsList.appendChild(productEl)
        });

}


(() => {
    console.log("My ebook store works");
    initializeEcommerce()
        .then(r => {});
})();