import axios from 'axios';
import authHeader from './auth-header';

const API_URL = 'http://localhost:8080/api/v1/project';

class ProjectService {
  getProjectType() {
    return axios.get(API_URL + '/type', { headers: authHeader() });
  }

  getProjectPriority() {
    return axios.get(API_URL + '/priority', { headers: authHeader() });
  }

  createProject(project) {
    return axios.post(API_URL, {project},{ headers: authHeader() });
  }
  getSectorDivision() {
    return axios.get(API_URL + '/sectorDivision', { headers: authHeader() });
  }

  getSector() {
    return axios.get(API_URL + '/sector', { headers: authHeader() });
  }

  getSubSector() {
    return axios.get(API_URL + '/subSector', { headers: authHeader() });
  }

  getCofoMain() {
    return axios.get(API_URL + '/cofoMain', { headers: authHeader() });
  }

  getCofoMainOptional() {
    return axios.get(API_URL + '/cofoMainOptional', { headers: authHeader() });
  }

  getCofoMainDetails() {
    return axios.get(API_URL + '/cofoMainDetails', { headers: authHeader() });
  }


}

export default new ProjectService();
