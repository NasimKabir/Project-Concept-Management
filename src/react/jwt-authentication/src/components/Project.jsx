import React, { useState, useEffect } from 'react'
import './Project.css';
import ProjectService from '../services/project.service';


const Project = () => {
    const [types, setTypes] = useState([]);
    const [priority, setPriority] = useState([]);
    const [sectorDIvison, SetSectorDIvison] = useState([]);
    const [sector, SetSector] = useState([]);
    const [subSector, SetSubSector] = useState([]);
    const [cofogMain, SetCofogMain] = useState([]);
    const [cofogMainOptional, SetCofogMainOptional] = useState([]);
    const [cofogMainDetails, SetCofogMainDetails] = useState([]);
    const [request, setRequest] = useState({
        projectCode: "",
        projectTitle: "",
        projectObjectives: "",
        projectType: "",
        projectPriority: "",
        dateOfCommencement: "",
        completetion: '',
        sectorDivision: '',
        sector: '',
        subSector: '',
        cofogMain:'',
        cofogMainOptional:'',
        cofogMainDetails:''
    });
    const [error, setError] = useState("");

    const onSubmit = (e) => {
        e.preventDefault();
        const project = { projectCode: request.projectCode, projectType: request.projectType, projectPriority: request.projectPriority, projectTitle: request.projectTitle, projectObjectives: request.projectObjectives };
        console.log('project => ' + project);
        console.log('project => ' + JSON.stringify(project));
        ProjectService.createProject(project).then(
            response => {
                console.log(response)
            },
            error => {
                const errorMessage = "Full authentication is required to access this resource";
                console.log("Login fail: error = { " + error.toString() + " }");
                setError(errorMessage);
            });
    }

    const getTypes = async () => {
        ProjectService.getProjectType().then(response => {
            console.log(response.data);
            setTypes(response.data);
        })
            .catch(error => console.log(error.response));

    }
    const getPriority = async () => {
        ProjectService.getProjectPriority().then(response => {
            console.log(response.data);
            setPriority(response.data);
        })
            .catch(error => console.log(error.response));

    }
    const getSectorDIvison = async () => {
        ProjectService.getSectorDivision().then(response => {
            console.log(response.data);
            SetSectorDIvison(response.data);
        })
            .catch(error => console.log(error.response));

    }

    const getSector = async () => {
        ProjectService.getSector().then(response => {
            console.log(response.data);
            SetSector(response.data);
        })
            .catch(error => console.log(error.response));

    }

    const getSubSector = async () => {
        ProjectService.getSubSector().then(response => {
            console.log(response.data);
            SetSubSector(response.data);
        })
            .catch(error => console.log(error.response));

    }

    const getSetCofogMain = async () => {
        ProjectService.getCofoMain().then(response => {
            console.log(response.data);
            SetCofogMain(response.data);
        })
            .catch(error => console.log(error.response));

    }
    const getCofoMainOptional = async () => {
        ProjectService.getCofoMainOptional().then(response => {
            console.log(response.data);
            SetCofogMainOptional(response.data);
        })
            .catch(error => console.log(error.response));

    }
    const getCofoMainDetails = async () => {
        ProjectService.getCofoMainDetails().then(response => {
            console.log(response.data);
            SetCofogMainDetails(response.data);
        })
            .catch(error => console.log(error.response));

    }
    useEffect(() => {
        getSetCofogMain()
    }, [])
    useEffect(() => {
        getCofoMainOptional()
    }, [])
    useEffect(() => {
        getCofoMainDetails()
    }, [])
    useEffect(() => {
        getSector()
    }, [])
    useEffect(() => {
        getSubSector()
    }, [])
    useEffect(() => {
        getTypes()
    }, [])
    useEffect(() => {
        getPriority()
    }, [])
    useEffect(() => {
        getSectorDIvison()
    }, [])
    return (
        <div>
            <form >
                <div className="row row-cols-1 row-cols-md-1 g-4 custom-border">
                    <div className="col">
                        <div className="card h-100 ">
                            <div className="card-header">
                                <h6 className="card-title ">Basic Information</h6>
                            </div>
                            <div className="card-body">

                                <label className="field">Project Code:</label>
                                <input type="text" onChange={e => setRequest({ ...request, projectCode: e.target.value })} />

                                <label className="field">Project Type : </label>
                                <select onChange={e => setRequest({ ...request, projectType: e.target.value })}>
                                    {types.map(item => (
                                        <option key={item.id} value={item.id}>
                                            {item.projectTypeName}
                                        </option>
                                    ))}
                                </select>

                                <label className="field">Priority : </label>
                                <select onChange={e => setRequest({ ...request, projectPriority: e.target.value })} >
                                    {priority.map(item => (
                                        <option
                                            key={item.id}
                                            value={item.id}
                                        >
                                            {item.projectPriorityeName}
                                        </option>
                                    ))}
                                </select>

                                <div className="mb-3">
                                    <label  >Title</label>
                                    <input type="text" className="form-control" onChange={e => setRequest({ ...request, projectTitle: e.target.value })} />
                                </div>
                                <div className="mb-3">
                                    <label className="form-label">Objectives</label>
                                    <textarea className="form-control" rows="3" onChange={e => setRequest({ ...request, projectObjectives: e.target.value })}  ></textarea>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div className="col">
                        <div className="card h-100 ">
                            <div className="card-header">
                                <h6 className="card-title ">Expected Implementation Period</h6>
                            </div>
                            <div className="card-body">

                                <label className="field">Date of Commencement:</label>
                                <input type="date" onChange={e => setRequest({ ...request, dateOfCommencement: e.target.value })} />

                                <label className="field">Date of Completion:</label>
                                <input type="date" onChange={e => setRequest({ ...request, completetion: e.target.value })} />

                            </div>
                        </div>
                    </div>

                    <div className="col">
                        <div className="card h-100 ">
                            <div className="card-header">
                                <h6 className="card-title ">The workings of the goverment and COFOG Selection</h6>
                            </div>
                            <div className="card-body">

                                <label className="field">Section Division : </label>
                                <select onChange={e => setRequest({ ...request, cofogMain: e.target.value })}>
                                    {cofogMain.map(item => (
                                        <option key={item.id} value={item.id}>
                                            {item.cofogMainName}
                                        </option>
                                    ))}
                                </select>
                                <br />
                                <br />
                                <h6 className="font-weight-bold">Project sector and subsector selection (as per ADP)</h6>
                                <br />
                                <label className="field">Sector : </label>
                                <select onChange={e => setRequest({ ...request, sector: e.target.value })} >
                                    {sector.map(item => (
                                        <option
                                            key={item.id}
                                            value={item.id}
                                        >
                                            {item.sectorName}
                                        </option>
                                    ))}
                                </select>
                                <label className="field">Sub Sector : </label>
                                <select onChange={e => setRequest({ ...request, subSector: e.target.value })} >
                                    {subSector.map(item => (
                                        <option
                                            key={item.id}
                                            value={item.id}
                                        >
                                            {item.subSectorName}
                                        </option>
                                    ))}
                                </select>
                                <br />
                                <br />
                                <h6 className="font-weight-bold">Classification of the fucntion of goverment(COFGO) </h6>
                                <br />
                                <label className="field">Main : </label>
                                <select onChange={e => setRequest({ ...request, subSector: e.target.value })} >
                                    {subSector.map(item => (
                                        <option
                                            key={item.id}
                                            value={item.id}
                                        >
                                            {item.subSectorName}
                                        </option>
                                    ))}
                                </select>
                                <label className="field">Optional : </label>
                                <select onChange={e => setRequest({ ...request, cofogMainOptional: e.target.value })} >
                                    {cofogMainOptional.map(item => (
                                        <option
                                            key={item.id}
                                            value={item.id}
                                        >
                                            {item.cofoMainNameOptional}
                                        </option>
                                    ))}
                                </select>
                                <label className="field">Details : </label>
                                <select onChange={e => setRequest({ ...request, cofogMainDetails: e.target.value })} >
                                    {cofogMainDetails.map(item => (
                                        <option
                                            key={item.id}
                                            value={item.id}
                                        >
                                            {item.cofogMainDetailsnName}
                                        </option>
                                    ))}
                                </select>
                                <br />
                                <br />
                                <h6 className="font-weight-bold">Funding Type </h6>
                                <br />
                            </div>
                        </div>
                    </div>


                    < button className="btn btn-primary" onClick={onSubmit} >Save & Next</button>
                    < button className="btn btn-secondary"  >Save & Exit</button>
                    {error && (
                        <div className="form-group">
                            <div className="alert alert-danger" role="alert">
                                {error}
                            </div>
                        </div>
                    )}
                </div>

            </form>
        </div>
    )
}

export default Project
