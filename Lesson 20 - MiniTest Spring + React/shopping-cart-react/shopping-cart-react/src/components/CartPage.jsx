import { useEffect, useState } from 'react'
import axios from 'axios';

let cartItems = []
const thumnailURL = "http://localhost:8080/photos/"
const API_URL = "http://localhost:8080/api/v1/cartItems"
function CartPage() {
  const [cartItemList, setCartItemList] = useState([])
  const [countList, setCountList] = useState([])
  const [total, setTotal] = useState(0)

  useEffect(() => {
    getItemList()
    calTotal()

  }, [])

  const getItemList = async () => {
    let res = await axios.get(`${API_URL}`)
    cartItems = res.data
    let countList = res.data.map(cartItem => cartItem.count);
    setCountList(countList)
    setCartItemList(cartItems);

    let sum = 0;
    cartItems.map(cartItem => sum+= (cartItem.course.price * cartItem.count))
    setTotal(sum);
  }


  const calTotal = async () => {
    let sum = 0;
    cartItems.map(cartItem => sum += (cartItem.course.price * cartItem.count))
    setTotal(sum);
  }


  async function increment(cartItemId) {
    try {
      let count = cartItems.find((cartItem) => cartItem.id === cartItemId).count;
      if (count >= 10) {
        return;
      }
      let res = await axios.put(`${API_URL}/${cartItemId}/increment`);

      if (res.status === 200) {
        cartItems.find((cartItem) => cartItem.id === cartItemId).count++;
        let countList = cartItems.map(cartItem => cartItem.count);
        setCountList(countList);
        calTotal();
      } else {
        console.log(res);
      }
    } catch (error) {
      console.log(error)
    }
  }


  async function decrement(cartItemId) {
    try {
      let count = cartItems.find((cartItem) => cartItem.id === cartItemId).count;
      if (count <= 1) {
        return;
      }
      let res = await axios.put(`${API_URL}/${cartItemId}/decrement`);

      if (res.status === 200) {
        cartItems.find((cartItem) => cartItem.id === cartItemId).count--;
        let countList = cartItems.map(cartItem => cartItem.count);
        setCountList(countList);
        calTotal();
      } else {
        console.log(res);
      }
    } catch (error) {
      console.log(error)
    }
  }


  async function deleteItem(cartItemId) {
    try {
      let res = await axios.delete(`${API_URL}/${cartItemId}`);

      if (res.status === 200) {
        cartItems = cartItems.filter(cartItem => cartItem.id !== cartItemId);
        let countList = cartItems.map(cartItem => cartItem.count);
        setCountList(countList)
        setCartItemList(cartItems);
        calTotal()
      }
    } catch (error) {
      console.log(error);
    }

  }


return (
  <>
    <div className="shopping-cart-container mt-5">
      <div className="container">
        <div className="row">
          <div className="col-md-12">
            <div className="mb-4">
              <h2>Shopping Cart</h2>
            </div>
          </div>
        </div>
        <p className="fst-italic message" style={{display: cartItemList.length === 0 ? '' : 'none'}} >Không có sản phẩm trong giỏ hàng</p>


        <div className="row shopping-cart">
          <div className="col-md-8">
            <div className="product-list">

              {cartItemList.map((cartItem, index) => (

                <div className="product-item d-flex border mb-4" key={cartItem.id}>
                  <div className="image">
                    <img src={`${thumnailURL}/${cartItem.course.thumbnail}`} alt={`sản phẩm ${index}`} />
                  </div>
                  <div className="info d-flex flex-column justify-content-between px-4 py-3 flex-grow-1">
                    <div>
                      <div className="d-flex justify-content-between align-items-center">
                        <h2 className="text-dark fs-5 fw-normal">
                          {cartItem.course.name}
                        </h2>
                        <h2 className="text-danger fs-5 fw-normal">
                          {cartItem.course.price * cartItem.count} VND
                        </h2>
                      </div>
                      <div className="text-black-50">
                        <div className="d-inline-block me-3">
                          <button className="border py-2 px-3 d-inline-block fw-bold bg-light" onClick={() => decrement(cartItem.id)}>-</button>
                          <span className="py-2 px-3 d-inline-block fw-bold"> {countList[index]}</span>
                          <button className="border py-2 px-3 d-inline-block fw-bold bg-light" onClick={() => increment(cartItem.id)}>+</button>
                        </div>
                      </div>
                    </div>
                    <div>
                      <button className="text-primary border-0 bg-transparent fw-light" onClick={() => deleteItem(cartItem.id)} >
                        <span><i className="fa-solid fa-trash-can"  ></i></span>
                        Xóa
                      </button>
                    </div>
                  </div>
                </div>

              ))}

            </div>
          </div>
          <div className="col-md-4">
            <div className="bill">
              <div className="border mb-2 p-3 fs-5 fw-normal d-flex justify-content-between align-items-center">
                <span className="text-black-50">Tạm tính:</span>
                <span className="text-primary" id="sub-total-money">{total} VND</span>
              </div>
              <div className="border mb-2 p-3 fs-5 fw-normal d-flex justify-content-between align-items-center">
                <span className="text-black-50">VAT (10%):</span>
                <span className="text-primary" id="vat-money">{total * 0.1} VND</span>
              </div>
              <div className="border mb-2 p-3 fs-5 fw-normal d-flex justify-content-between align-items-center">
                <span className="text-black-50">Thành tiền:</span>
                <span className="text-primary" id="total-money">{total + total * 0.1}VND</span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>


  </>
)
}

export default CartPage
