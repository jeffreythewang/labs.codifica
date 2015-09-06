class Method extends React.Component {
  render() {
    return (
      <div className="Method">
        <h2>{this.props.name}</h2>
      </div>
    );
  }
}

Method.propTypes = {
  name: React.PropTypes.string,
};

class MethodContainer extends React.Component {
  render() {
    return (
      <div className="MethodContainer">
        <Method name={'Aeropress'}/>
        <Method name={'French Press'} />
        <Method name={'V60'} />
        <Method name={'Chemex'} />
        <Method name={'Kalita'} />
        <Method name={'Cold Brew'} />
      </div>
    );
  }
}

class App extends React.Component {
  render() {
    return (
      <div className="App">
        <h1>Codifica Labs</h1>
        <div className="header">
          <p>We at Codifica have been experimenting with different home brewing processes. With each bag of beans we get our hands on comes a different palette of roasting notes. Extracting these flavors involves a variety of processes. It has become our pleasure to report our findings in our journey throughout fourth wave coffee.</p>
        </div>
        <MethodContainer />
      </div>
    );
  }
}

