class Method extends React.Component {
  render() {
    return (
      <div className="Method">
        <h1>{this.props.type}</h1>
      </div>
    );
  }
}

Method.propTypes = {
  type: React.PropTypes.string
};

class MethodContainer extends React.Component {
  render() {
    return (
      <div className="MethodContainer">
        <Method type={'Aeropress'}/>
        <Method type={'French Press'} />
        <Method type={'V60'} />
        <Method type={'Chemex'} />
      </div>
    );
  }
}

class App extends React.Component {
  render() {
    return (
      <div className="App">
        <h1>Codifica Labs</h1>
        <p>brief description of codifica labs goes here</p>
        <MethodContainer />
      </div>
    );
  }
}

