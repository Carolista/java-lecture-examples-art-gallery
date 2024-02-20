const Header = () => {
  return (
    <>
      <header>
        <div id="mag"><b>Midtown</b> Art Gallery</div>
        <div className="nav">
            <a className="navlink" href="/artworks">Artworks</a>
            <span className="faux-link">Exhibitions</span>
            <span className="faux-link">Contact Us</span>
        </div>
      </header>
    </>
  )
}

export default Header;
