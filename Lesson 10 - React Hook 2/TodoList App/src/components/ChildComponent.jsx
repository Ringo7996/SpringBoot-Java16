import React, { useState } from 'react'
import {ExampleContext} from '../App.jsx'


const ChildComponent = () => {
  const { color } = React.useContext(ExampleContext);

  return <p style={{ color }}>This text is {color}</p>;
};

export default ChildComponent;