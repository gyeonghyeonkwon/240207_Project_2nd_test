import logo from './logo.svg';
import './App.css';
import './index.css';
import { Routes, Route} from "react-router-dom";
import Login from './member/Login';
import List from './post/List';

function App() {
  return (
   <Routes>
       <Route path='/member/login' element={<Login/>}/>
       <Route path='/post/list' element={<List/>}/>
   </Routes>
)
}

export default App;
