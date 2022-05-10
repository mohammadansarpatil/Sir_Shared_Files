import { ActionTypes } from "../constants/action-types";
import fakeStoreapi from "../../apis/fakeStoreApi"

// export const fetchProducts=async()=>{
//   const response = await axios.get("/products")
//   console.log(response)
//   return{
//     type: ActionTypes.SET_PRODUCTS,
//     payload: response
//   }
// }

export const fetchProducts= ()=>{

  return async function (dispatch, getState){

    const response = await fakeStoreapi.get('/products')
    dispatch({type : ActionTypes.FETCH_PRODUCTS,payload:response.data})

  }

}

export const setProducts = (products) => {
  return {
    type: ActionTypes.SET_PRODUCTS,
    payload: products,
  };
};

export const selectedProduct = (product) => {
  return {
    type: ActionTypes.SELECTED_PRODUCT,
    payload: product,
  };
};
export const removeSelectedProduct = () => {
  return {
    type: ActionTypes.REMOVE_SELECTED_PRODUCT,
  };
};
