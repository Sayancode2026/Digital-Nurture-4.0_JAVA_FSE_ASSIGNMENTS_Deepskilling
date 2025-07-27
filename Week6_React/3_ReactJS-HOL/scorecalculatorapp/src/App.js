import { CalculateScore } from './components/CalculateScore';
import './App.css';

function App() {
  return (
    <div>
      <CalculateScore Name={"Sayan"}
        School={"DNV Public School"}
        total={284}
        goal={300}
      />
    </div>
  )
}

export default App;