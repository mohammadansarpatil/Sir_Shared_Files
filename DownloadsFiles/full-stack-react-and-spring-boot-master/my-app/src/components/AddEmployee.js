import { useState } from "react";
import { Link, useHistory, useParams } from "react-router-dom";
import { useEffect } from "react/cjs/react.development";
import employeeService from "../services/employee.service";



const AddEmployee = () => {
    const[name, setName] = useState('');
    const[location, setLocation] = useState('');
    const[department, setDepartment] = useState('');
    const[dateOfJoining, setDateOfJoining] = useState(new Date());
    const[income, setIncome]=useState('');
    const[city , setCity] = useState('');
    const[profilePicture , setProfilePicture] = useState('');
    const history = useHistory();
    const {id} = useParams();


    const saveEmployee = (e) => {
        e.preventDefault();
        
        const employee = {name, location, department, city, income, dateOfJoining, profilePicture, id};
        if (id) {
            //update
            employeeService.update(employee)
                .then(response => {
                    console.log('Employee data updated successfully', response.data);
                    history.push('/');
                })
                .catch(error => {
                    console.log('Something went wrong', error);
                }) 
        } else {
            //create
            employeeService.create(employee)
            .then(response => {
                console.log("employee added successfully", response.data);
                history.push("/");
            })
            .catch(error => {
                console.log('something went wroing', error);
            })
        }
    }

    useEffect(() => {
        if (id) {
            employeeService.get(id)
                .then(employee => {
                    setName(employee.data.name);
                    setLocation(employee.data.location);
                    setDepartment(employee.data.department);
                    setIncome(employee.data.income);
                    setCity(employee.data.city);
                    setDateOfJoining(employee.data.dateOfJoining);
                    setProfilePicture(employee.data.profilePicture);
                })
                .catch(error => {
                    console.log('Something went wrong', error);
                })
        }
    }, [])
    return(
        <div className="container">
            <h3>Add Employee</h3>
            <hr/>
            <form>
                <div className="form-group">
                    <input 
                        type="text" 
                        className="form-control col-4"
                        id="name"
                        value={name}
                        onChange={(e) => setName(e.target.value)}
                        placeholder="Enter name"
                    />

                </div>
                <div className="form-group">
                    <input 
                        type="text" 
                        className="form-control col-4"
                        id="department"
                        value={department}
                        onChange={(e) => setDepartment(e.target.value)}
                        placeholder="Enter Department"
                    />
                </div>
                <div className="form-group">
                    <input 
                        type="text" 
                        className="form-control col-4"
                        id="location"
                        value={location}
                        onChange={(e) => setLocation(e.target.value)}
                        placeholder="Enter Location"
                    />
                </div>

                <div className="form-group">
                    <input 
                        type="text" 
                        className="form-control col-4"
                        id="income"
                        value={income}
                        onChange={(e) => setIncome(e.target.value)}
                        placeholder="Enter Income"
                    />
                </div>


                <div className='form-group'>
                <input className="form-control col-4" 
                value={city} 
                onChange={(e)=>setCity(e.target.value)}
                list="datalistOptions" id="exampleDataList" placeholder="Enter City"/>
                            <datalist id="datalistOptions">
                            <option value="San Francisco"/>
                            <option value="New York"/>
                            <option value="Seattle"/>
                            <option value="Los Angeles"/>
                            <option value="Chicago"/>
                        </datalist>
                </div>

                <div className="form-group">
                    <label for="doj">Enter Joining date</label>
                    <input 
                        type="date" 
                        className="form-control col-4"
                        id="doj"
                        data-date-format="DD MMMM YYYY"
                        value={dateOfJoining}
                        onChange={(e) => setDateOfJoining(e.target.value)}
                    />
                </div>


        
        <div className="form-group">
                    <input 
                        type="text" 
                        className="form-control col-4"
                        id="profilepicture"
                        value={profilePicture}
                        onChange={(e) => setProfilePicture(e.target.value)}
                        placeholder="Provide DP Link "
                    />
                </div>

                <div >
                    <button onClick={(e) => saveEmployee(e)} className="btn btn-primary">Save</button>
                </div>
            </form>
            <hr/>
            <Link to="/">Back to List</Link>
        </div>
    )
}

export default AddEmployee;