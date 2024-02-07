import logo from './logo.svg';
import './App.css';
import './index.css';
import { Routes, Route} from "react-router-dom";
import Login from './member/Login';

function App() {
  return (
   <Routes>
       <Route path='/member/login' element={<Login/>}/>
   </Routes>
)
}

export default App;
