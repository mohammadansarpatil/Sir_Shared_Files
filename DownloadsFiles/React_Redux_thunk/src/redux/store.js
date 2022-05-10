import { applyMiddleware, compose, createStore } from "redux";
import thunk from 'redux-thunk'
import reducers from "./reducers/index";

const cE=window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose



const store = createStore(
  reducers,
  cE(applyMiddleware(thunk))
 
);

export default store;
